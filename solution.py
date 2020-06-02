# Employee-Name id Manager-id
# Alan 100 150
# Martin 220 100
# Jamie 150
# Alex 275 100
# Steve 400 150
# David 190 400


class Solution:

    # Building lookup to find name of the employee by employee-id
    def _create_lookup(self, rows):
        lookup = {}

        for row in rows:
            employee, id = row[0], row[1]
            lookup[id] = employee

        return lookup

    # Building relationships {manager:[employee1, employee2]}
    def _create_relationships(self, rows):
        ceo = None
        relationships = {}
        lookup = self._create_lookup(rows=rows)

        for row in rows:
            employee, manager = row[0], lookup[row[2]] if row[2] else None

            if manager:
                if manager in relationships:
                    relationships[manager].append(employee)
                else:
                    relationships[manager] = [employee]
            else:
                # No manager means CEO
                ceo = employee

        return ceo, relationships

    def pretty_print(self, rows):
        ceo, relationships = self._create_relationships(rows=rows)
        self._pretty_print(ceo, relationships, "--")

    def _pretty_print(self, manager, relationships, prefix):
        print("{}>{}".format(prefix, manager))
        if manager in relationships:
            for employee in relationships[manager]:
                self._pretty_print(employee, relationships, prefix+"--")


if __name__ == '__main__':
    solution = Solution()

    rows = [
        ("Alan", 100, 150),
        ("Martin", 220, 100),
        ("Jamie", 150, None),
        ("Alex", 275, 100),
        ("Steve", 400, 150),
        ("David", 190, 400)
    ]

    # Input 1: Given in the problem
    solution.pretty_print(rows)

    # Input 2: Invalid input with wrong manager id - 100
    rows = [
        ("Alan", 101, 150),
        ("Martin", 220, 100),
        ("Jamie", 150, None),
        ("Alex", 275, 100),
        ("Steve", 400, 150),
        ("David", 190, 400)
    ]

    try:
        solution.pretty_print(rows)
    except KeyError as ke:
        print('Unable to find employee with id {}'.format(ke.args[0]))

    # Input 3: one entry
    rows = [
        ("Alan", 100, None)
    ]

    solution.pretty_print(rows)

    # Input 4: no entry
    rows = []
    solution.pretty_print(rows)
