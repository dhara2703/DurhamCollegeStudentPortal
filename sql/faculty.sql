-- Name       : Dhara Savaliya
-- Date       : 23 January 2019
-- File Name  : faculty.sql 
-- Description: This is faculty sql file which will be helpful to store the information 
--              such as id (foreign key with reference of users.sql), school code, school description,
--              office and extentision.


DROP TABLE IF EXISTS Faculty;
CREATE TABLE Faculty(
	Id BIGINT primary key,
	SchoolCode VARCHAR(4),
	SchoolDescription VARCHAR(60),
	Office VARCHAR(10),
	Extension SMALLINT,
	FOREIGN KEY (Id) REFERENCES users(Id)
);
ALTER TABLE Faculty OWNER TO webd4201_admin;
INSERT INTO Faculty(Id, SchoolCode, SchoolDescription, Office, Extension) 
             VALUES (100111001, 'BITM', 'School of Business, IT & Management', 'C-223', 7383);

INSERT INTO Faculty(Id, SchoolCode, SchoolDescription, Office, Extension) 
             VALUES (100001011, 'SET', 'School of Science & Engineering Technology', 'H140F', 2319);

INSERT INTO Faculty(Id, SchoolCode, SchoolDescription, Office, Extension) 
             VALUES (100111112, 'BITM', 'School of Business, IT & Management', 'C-223', 7383);
             

--SELECT * FROM Faculty;