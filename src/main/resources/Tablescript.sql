DROP SCHEMA IF EXISTS  telecom_domain_db;

CREATE SCHEMA telecom_domain_db;
USE telecom_domain_db;

create table Sim_Details (
                            sim_id Int AUTO_INCREMENT,
                            service_Number INT not null,
                            sim_number VARCHAR(20) not null,
                            sim_status VARCHAR(20) not null,
                            CONSTRAINT ps_sim_id_pk PRIMARY KEY (sim_id)
);

INSERT INTO Sim_Details VALUES(1,1234567891,1234567891234,'active');
INSERT INTO Sim_Details VALUES(2,1234567892,1234567891235,'inactive');
COMMIT;
SELECT * FROM Sim_Details;