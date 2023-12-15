DROP TABLE IF EXISTS student;
DROP SEQUENCE IF EXISTS student_sequence;

CREATE SEQUENCE student_sequence START WITH 0 INCREMENT BY 1;

--creating the table student--
--creating the table student--
CREATE TABLE IF NOT EXISTS student (
    id INT DEFAULT NEXT VALUE FOR student_sequence PRIMARY KEY,
    name VARCHAR(100),
    age SMALLINT
);