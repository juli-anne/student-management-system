INSERT INTO studentDto (first_name, last_name, program)
SELECT 'Anna', 'Smith', 'Marketing'
WHERE NOT EXISTS (
    SELECT 1 FROM studentDto WHERE first_name = 'Anna' AND last_name = 'Smith'
);

INSERT INTO studentDto (first_name, last_name, program)
SELECT 'Marc', 'Lang', 'Business'
WHERE NOT EXISTS (
    SELECT 1 FROM studentDto WHERE first_name = 'Marc' AND last_name = 'Lang'
);

INSERT INTO studentDto (first_name, last_name, program)
SELECT 'Steve', 'Rogers', 'Mathematics'
WHERE NOT EXISTS (
    SELECT 1 FROM studentDto WHERE first_name = 'Steve' AND last_name = 'Rogers'
);

INSERT INTO studentDto (first_name, last_name, program)
SELECT 'Alex', 'Snow', 'Marketing'
WHERE NOT EXISTS (
    SELECT 1 FROM studentDto WHERE first_name = 'Alex' AND last_name = 'Snow'
);

INSERT INTO studentDto (first_name, last_name, program)
SELECT 'Robert', 'Wills', 'Business'
WHERE NOT EXISTS (
    SELECT 1 FROM studentDto WHERE first_name = 'Robert' AND last_name = 'Wills'
);
