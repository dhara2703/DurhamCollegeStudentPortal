-- Name       : Dhara Savaliya
-- Date       : 23 January 2019
-- File Name  : schools.sql 
-- Description: This is students sql file which will be helpful to store the 
--              information such as id (foreign key with reference of users.sql), program code, program description
--              and year. 

DROP TABLE IF EXISTS Schools;
CREATE TABLE Schools(
	SchoolCode VARCHAR(2) Primary Key,
    SchoolDescription VARCHAR(40) NOT NULL
);
ALTER TABLE Schools OWNER TO webd4201_admin;



-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SV','Centre for Food');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SH','School of Hlth & Comm Services');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SM','School of Media, Art & Design');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SQ','Sch of Science & Engineer Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SN','SchSkill Trd, Appr &Renew Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SB','School of Business');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SV','Centre for Food');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SK','School of Justice & Emerg Serv');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SO','School College Work Initiative');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SY','Sch Interdisciplinary Studies');

-- select * from Schools;



-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SV','Centre for Food');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SH','School of Hlth & Comm Services');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SH','School of Hlth & Comm Services');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SM','School of Media, Art & Design');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SM','School of Media, Art & Design');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SM','School of Media, Art & Design');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SH','School of Hlth & Comm Services');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SM','School of Media, Art & Design');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SM','School of Media, Art & Design');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SQ','Sch of Science & Engineer Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SQ','Sch of Science & Engineer Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SM','School of Media, Art & Design');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SN','SchSkill Trd, Appr &Renew Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SB','School of Business');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SQ','Sch of Science & Engineer Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SQ','Sch of Science & Engineer Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SQ','Sch of Science & Engineer Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SM','School of Media, Art & Design');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SQ','Sch of Science & Engineer Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SH','School of Hlth & Comm Services');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SH','School of Hlth & Comm Services');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SN','SchSkill Trd, Appr &Renew Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SH','School of Hlth & Comm Services');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SQ','Sch of Science & Engineer Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SQ','Sch of Science & Engineer Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SQ','Sch of Science & Engineer Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SQ','Sch of Science & Engineer Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SQ','Sch of Science & Engineer Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SQ','Sch of Science & Engineer Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SH','School of Hlth & Comm Services');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SQ','Sch of Science & Engineer Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SV','Centre for Food');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SN','SchSkill Trd, Appr &Renew Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SN','SchSkill Trd, Appr &Renew Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SV','Centre for Food');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SK','School of Justice & Emerg Serv');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SK','School of Justice & Emerg Serv');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SQ','Sch of Science & Engineer Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SK','School of Justice & Emerg Serv');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SQ','Sch of Science & Engineer Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SM','School of Media, Art & Design');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SH','School of Hlth & Comm Services');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SH','School of Hlth & Comm Services');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SH','School of Hlth & Comm Services');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SO','School College Work Initiative');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SO','School College Work Initiative');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SH','School of Hlth & Comm Services');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SM','School of Media, Art & Design');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SM','School of Media, Art & Design');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SH','School of Hlth & Comm Services');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SH','School of Hlth & Comm Services');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SH','School of Hlth & Comm Services');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SN','SchSkill Trd, Appr &Renew Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SN','SchSkill Trd, Appr &Renew Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SQ','Sch of Science & Engineer Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SQ','Sch of Science & Engineer Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SQ','Sch of Science & Engineer Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SK','School of Justice & Emerg Serv');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SK','School of Justice & Emerg Serv');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SQ','Sch of Science & Engineer Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SQ','Sch of Science & Engineer Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SQ','Sch of Science & Engineer Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SM','School of Media, Art & Design');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SM','School of Media, Art & Design');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SH','School of Hlth & Comm Services');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SK','School of Justice & Emerg Serv');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SK','School of Justice & Emerg Serv');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SM','School of Media, Art & Design');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SY','Sch Interdisciplinary Studies');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SY','Sch Interdisciplinary Studies');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SY','Sch Interdisciplinary Studies');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SY','Sch Interdisciplinary Studies');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SY','Sch Interdisciplinary Studies');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SY','Sch Interdisciplinary Studies');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SY','Sch Interdisciplinary Studies');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SY','Sch Interdisciplinary Studies');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SM','School of Media, Art & Design');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SM','School of Media, Art & Design');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SN','SchSkill Trd, Appr &Renew Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SV','Centre for Food');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SV','Centre for Food');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SV','Centre for Food');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SV','Centre for Food');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SN','SchSkill Trd, Appr &Renew Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SM','School of Media, Art & Design');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SM','School of Media, Art & Design');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SM','School of Media, Art & Design');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SO','School College Work Initiative');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SK','School of Justice & Emerg Serv');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SK','School of Justice & Emerg Serv');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SK','School of Justice & Emerg Serv');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SK','School of Justice & Emerg Serv');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SH','School of Hlth & Comm Services');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SM','School of Media, Art & Design');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SM','School of Media, Art & Design');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SQ','Sch of Science & Engineer Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SQ','Sch of Science & Engineer Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SM','School of Media, Art & Design');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SN','SchSkill Trd, Appr &Renew Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SN','SchSkill Trd, Appr &Renew Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SN','SchSkill Trd, Appr &Renew Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SN','SchSkill Trd, Appr &Renew Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SQ','Sch of Science & Engineer Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SQ','Sch of Science & Engineer Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SK','School of Justice & Emerg Serv');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SK','School of Justice & Emerg Serv');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SK','School of Justice & Emerg Serv');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SH','School of Hlth & Comm Services');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SK','School of Justice & Emerg Serv');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SN','SchSkill Trd, Appr &Renew Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SK','School of Justice & Emerg Serv');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SM','School of Media, Art & Design');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SQ','Sch of Science & Engineer Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SQ','Sch of Science & Engineer Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SY','Sch Interdisciplinary Studies');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SY','Sch Interdisciplinary Studies');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SY','Sch Interdisciplinary Studies');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SH','School of Hlth & Comm Services');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SH','School of Hlth & Comm Services');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SH','School of Hlth & Comm Services');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SK','School of Justice & Emerg Serv');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SK','School of Justice & Emerg Serv');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SK','School of Justice & Emerg Serv');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SH','School of Hlth & Comm Services');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SM','School of Media, Art & Design');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SO','School College Work Initiative');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SV','Centre for Food');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SV','Centre for Food');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SX','School of Bus, IT & Management');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SH','School of Hlth & Comm Services');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SN','SchSkill Trd, Appr &Renew Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SK','School of Justice & Emerg Serv');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SM','School of Media, Art & Design');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SQ','Sch of Science & Engineer Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SN','SchSkill Trd, Appr &Renew Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SN','SchSkill Trd, Appr &Renew Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SN','SchSkill Trd, Appr &Renew Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SQ','Sch of Science & Engineer Tech');
-- INSERT INTO Schools(SchoolCode, SchoolDescription) VALUES ('SK','School of Justice & Emerg Serv');


-- select * from programs, schools where schools.schoolcode = 'SV' and programs.schoolcode = schools.schoolcode;
