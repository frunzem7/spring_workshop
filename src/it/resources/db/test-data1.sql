CREATE SEQUENCE IF NOT EXISTS seq_employee START WITH 2;
INSERT INTO employee VALUES (nextval('seq_employee'), 'elina.turcanu@endava.com', 'Elina Turcanu', '1111',
                             'b805544a-3ff3-42b2-8153-281a01ca0443', null);
INSERT INTO stream VALUES (1, 'AM', 'JAVA','stream_uuid', null);
