INSERT INTO clients (surname, name, patronym, phone) VALUES ('Ермилов','Михаил','Анатольевич','8(123)456-78-90');
INSERT INTO clients (surname, name, patronym, phone) VALUES ('Ермилов','Михаил','Анатольевич','8(123)456-78-93');
INSERT INTO clients (surname, name, patronym, phone) VALUES ('Баранов','Алексей','Михайлович','8(123)456-78-91');

INSERT INTO automobiles (mark, model, gosnumber, client_id, status) VALUES ('BMW','M5','P444MP456rus',1,false);
INSERT INTO automobiles (mark, model, gosnumber, client_id, status) VALUES ('BMW','M2','P444MP457rus',1,true);
INSERT INTO automobiles (mark, model, gosnumber, client_id, status) VALUES ('BMW','M3','P444MP458rus',1,true);
INSERT INTO automobiles (mark, model, gosnumber, client_id, status) VALUES ('BMW','M4','P444MP459rus',1,true);

INSERT INTO automobiles (mark,model,gosnumber,client_id, status) VALUES ('AUDI','A4','A234PM33rus',2,true);

INSERT INTO services (name,price,status) VALUES ('Мойка автомобиля',500,false);
INSERT INTO services (name,price,status) VALUES ('Мойка автомобиля',600,true);
INSERT INTO services (name,price,description,status) VALUES ('Оклейка автомобиля антигравийной пленкой',12500,'Антигравийная полиуретановая пленка SunTek PPF состоит из 5 слоев, каждый из которых несет свою функцию. Главной отличительной особенностью полиуретановой пленки от виниловой является ее плотность.',true);
INSERT INTO services (name,price,description,status) VALUES ('test',12500,'dddd',true);


INSERT INTO employers (surname, name, patronym, phone, city, street, house, status) VALUES ('Зубова','Альбина','Артёмовна','8(777)434-22-11', 'Навашино', 'Муромская', 14,false);
INSERT INTO employers (surname, name, patronym, phone, city, street, house, appartment,status) VALUES ('Зубова','Альбина','Артёмовна','8(777)434-22-11', 'Муром', 'Муромская', 14, 1,true);
INSERT INTO employers (surname, name, patronym, phone, city, street, house, appartment,status) VALUES ('Карасёв','Эдуард','Михайлович','8(777)434-22-12', 'Навашино', 'Московская', 16, 1,true);
INSERT INTO employers (surname, name, patronym, phone, city, street, house,status) VALUES ('Зубарев','Аркадий','Петрович','8(444)233-33-51', 'Москва', 'Московская', 19,true);
INSERT INTO employers (surname, name, patronym, phone, city, street, house,status) VALUES ('Зубарева','Альбина','Михайлович','8(444)233-33-52', 'Муром', 'Муромская', 22,true);

INSERT INTO providedservices (service_id, employer_id, automobile_id, dateofprovide) VALUES (1, 1, 1, '2020-02-19');
INSERT INTO providedservices (service_id, employer_id, automobile_id, dateofprovide) VALUES (1, 2, 1, '2024-02-19');
INSERT INTO providedservices (service_id, employer_id, automobile_id, dateofprovide) VALUES (2, 3, 2, '2021-02-19');
INSERT INTO providedservices (service_id, employer_id, automobile_id, dateofprovide) VALUES (2, 4, 2, '2022-02-19');

INSERT INTO users (username, password, role) VALUES ('admin','$2a$10$rQwyOmpHusvvnf7GXPLHYO0f264VlaIqB59X2R8dmIbD7dBT3Y9TS','ROLE_ADMIN');
INSERT INTO users (username, password, role) VALUES ('employer','$2a$10$GRkMVl9Q3Pei9ZmU3zFZN.jrI6htFciAgVqkqiqY5s7SQKrNpXLVe','ROLE_EMPLOYER');

INSERT INTO users (username, password, role) VALUES ('8(123)456-78-90','$2a$10$vtbT3YfR1pEyT9Y.HAvj/.LQX4otxeb9IeIlKGpv5eczPncNurpXK','ROLE_USER');
INSERT INTO users (username, password, role) VALUES ('8(123)456-78-93','$2a$10$2GIUAWgIvfGSP0UDdONZoO02yO7lFydySdknoB9R/36ZEClcp.ANu','ROLE_USER');
INSERT INTO users (username, password, role) VALUES ('8(123)456-78-91','$2a$10$pmFCKepmk2eq8hOYHinq6OoA1uQ8HRBlAsYcXfg5GfIQBS41dV2.y','ROLE_USER');