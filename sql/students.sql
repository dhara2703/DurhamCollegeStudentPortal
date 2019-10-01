-- Name       : Dhara Savaliya
-- Date       : 23 January 2019
-- File Name  : students.sql 
-- Description: This is students sql file which will be helpful to store the 
--              information such as id (foreign key with reference of users.sql), program code, program description
--              and year. 

DROP TABLE IF EXISTS Students;
CREATE TABLE Students(
	Id BIGINT primary key,
	ProgramCode VARCHAR(4),
	ProgramDescription VARCHAR(60),
	Year SMALLINT,
	FOREIGN KEY (Id) REFERENCES users(Id) ON DELETE CASCADE
);
ALTER TABLE Students OWNER TO webd4201_admin;

INSERT INTO Students(Id, programCode, programDescription, year) 
             VALUES (100648840, 'CPA', 'Computer Programmer Analyst', 2);

INSERT INTO Students(Id, programCode, programDescription, year) 
             VALUES (100111111, 'CSTY', 'Computer System Technology', 3);

INSERT INTO Students(Id, programCode, programDescription, year) 
             VALUES (100111110, 'AIDI', 'Artificial Intelligence Analysis, Design and Implementation', 1);
--SELECT * FROM Students;
