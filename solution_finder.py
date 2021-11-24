"""
Try a simple greedy method to build up a solution to the mapping problem in the design contest.
"""

import csv
from pprint import pprint


# Before anything runs properly, load up the task and flow utilisation information
TASK_UTILISATIONS = {}
with open("Tasks.csv") as csvfile:
    reader = csv.DictReader(csvfile)
    for r in reader:
        TASK_UTILISATIONS[int(r["Task"])] = float(r["Utilisation"])

FLOWS = []
with open("Flows.csv") as csvfile:
    reader = csv.DictReader(csvfile)
    for r in reader:
        utilisation = float(r["Utilisation"])
        sender = int(r["SenderTask"])
        dest = int(r["DestinationTask"])
        FLOWS.append((utilisation, sender, dest))


def get_total_flow_utilisation_both_ways(task):
    """
    Calculates the total utilisation this task has, both in and out.
    :param task:
    :return:
    """
    if task >= len(TASK_UTILISATIONS):
        raise ValueError(f"No task {task}")
    return sum(x[0] for x in FLOWS if x[1] == task or x[2] == task)


def cells_are_adjacent(cell1, cell2):
    """
    Returns true if these two cells are adjacent to one another.
    :param cell1:
    :param cell2:
    :return:
    """
    dist_x = abs(cell1[0] - cell2[0])
    dist_y = abs(cell1[1] - cell2[1])
    return (dist_x == 1 and dist_y == 0) or (dist_x == 0 and dist_y == 1)


def plot_route(source, destination):
    """
    Takes two tuples constituting cell coordinates and gives a list of frozensets, which represents the route from
    the source to the destination.
    :param source:
    :param destination:
    :return:
    """
    route = []
    current_location = source
    # Traverse x coordinates then y coordinates
    while True:
        if current_location[0] != destination[0]:
            # Still not in the same column
            if destination[0] > current_location[0]:
                # Need to move to the right
                route.append(frozenset((current_location, (current_location[0]+1, current_location[1]))))
                current_location = (current_location[0]+1, current_location[1])
            else:
                # Need to move to the left
                route.append(frozenset((current_location, (current_location[0] - 1, current_location[1]))))
                current_location = (current_location[0] - 1, current_location[1])
            continue

        if current_location[1] == destination[1]:
            # We must have finished the journey
            return route

        # If here, we've reached the x coordinate but not the y-coordinate
        if destination[1] > current_location[1]:
            # Need to move to the right
            route.append(frozenset((current_location, (current_location[0], current_location[1] + 1))))
            current_location = (current_location[0], current_location[1] + 1)
        else:
            # Need to move to the left
            route.append(frozenset((current_location, (current_location[0], current_location[1] - 1))))
            current_location = (current_location[0], current_location[1] - 1)


class Solution:
    """
    A solution is fundamentally a mapping from task ID to coordinates.
    """

    def __init__(self, meshX, meshY):
        self.meshX = meshX
        self.meshY = meshY
        self.grid = []
        self.link_utilisations = {}
        self.tasks = []

        # Populate the grid
        for i in range(meshX):
            row = []
            self.grid.append(row)
            for j in range(meshY):
                # Each list here represents a cell. The contents will be a list of task IDs.
                row.append([])

        # Set all the link utilisations to 0
        # This dict maps a frozenset of tuples {from_coords, to_coords} to an integer
        for i in range(meshX):
            for j in range(meshY):
                for k in range(meshX):
                    for l in range(meshY):
                        # See if (i, j) is next to (k, l)
                        if cells_are_adjacent((i, j), (k, l)):
                            self.link_utilisations[frozenset(((i, j), (k, l)))] = 0

        pprint(self.grid)
        pprint(self.link_utilisations)

    def __setitem__(self, key, value):
        """
        Take a task ID and add it to this grid, raising an error if the utilisation would be too high.
        :param key:
        :param value:
        :return:
        """
        # First check the task utilisation would work
        if TASK_UTILISATIONS[key] + self.get_cell_utilisation(value) > 1:
            raise Exception(f"Can't assign task {key} to cell {value}: Utilisation too high")

        # Then check the local link utilisation would work
        if self.get_local_link_utilisation(value) + get_total_flow_utilisation_both_ways(key) > 1:
            raise Exception(f"Task {key} would exceed local link utilisation of {value}")

        # Now the hard part: work out all the links
        relevant_flows = [x for x in FLOWS if x[1] == key or x[2] == key]
        for flow in relevant_flows:
            if flow[1] not in self.tasks + [key] or flow[2] not in self.tasks + [key]:
                # This flow references a task which is not yet mapped
                continue

            # Plot the route from the source to the destination, then check if all the links can have the utilisation
            route = plot_route(self.get_task_cell(flow[1]), self.get_task_cell(flow[2]))
            for link in route:
                if self.link_utilisations[link] + flow[0] > 1:
                    raise Exception(f"Adding task {key} to {value} will overload link {link}")

        # If we got here then everything is fine
        self.tasks.append(key)
        self.grid[value[0]][value[1]].append(key)
        for flow in relevant_flows:
            if flow[1] not in self.tasks + [key] or flow[2] not in self.tasks + [key]:
                # This flow references a task which is not yet mapped
                continue

            # Plot the route from the source to the destination, then check if all the links can have the utilisation
            route = plot_route(self.get_task_cell(flow[1]), self.get_task_cell(flow[2]))
            for link in route:
                self.link_utilisations[link] += flow[0]

    def get_cell_utilisation(self, cell_coords):
        """
        Gets the current utilisation of the cell at the given coordinates
        :param cell_coords:
        :return:
        """
        cell = self.grid[cell_coords[0]][cell_coords[1]]
        return sum(TASK_UTILISATIONS[x] for x in cell)

    def get_local_link_utilisation(self, cell_coords):
        """
        Gets the local link utilisation of all the tasks in this cell.
        :param cell_coords:
        :return:
        """
        return sum(get_total_flow_utilisation_both_ways(t) for t in self.grid[cell_coords[0]][cell_coords[1]])

    def get_task_cell(self, task):
        """
        Returns the cell this task is in
        :param task:
        :return:
        """
        for x in range(self.meshX):
            for y in range(self.meshY):
                if task in self.grid[x][y]:
                    return x, y
        # Not found it so it can't be here
        raise ValueError(f"Solution does not yet have task {task}")

    def __str__(self):
        return str(self.grid)


def find_solution(meshX, meshY):
    """
    Finds a solution using a greedy method. It does:
    1. Set factorC and factorI to 1.199
    2. Run through the list of flows, from highest utilisation to lowest
    3. For each flow, find the destination which is optimal right now
    4. At the end of this, find the highest utilisation link and processor, and alter factorC and factorI to be as
    low as they can get.

    A solution is a mapping from task ID to processor coordinate.
    :param meshX:
    :param meshY:
    :return:
    """
    solution = {}
    flows = list(sorted(FLOWS, key=lambda x: x[0], reverse=True))



def main():
    # Find a solution
    print(Solution(5, 5).get_cell_utilisation((2, 2)))
    find_solution(3, 5)


if __name__ == "__main__":
    main()
