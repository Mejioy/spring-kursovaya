INSERT INTO clients (surname,name,patronym,phone) VALUES ('Ермилов','Михаил','Анатольевич','8(123)456-78-90');
INSERT INTO clients (surname,name,patronym,phone) VALUES ('Ермилов','Михаил','Анатольевич','8(123)456-78-93');
INSERT INTO clients (surname,name,patronym,phone) VALUES ('Баранов','Алексей','Михайлович','8(123)456-78-91');

INSERT INTO automobiles (mark,model,gosnumber,client_id) VALUES ('BMW','M5','P444MP456rus',1);
INSERT INTO automobiles (mark,model,gosnumber,client_id) VALUES ('BMW','M2','P444MP457rus',1);
INSERT INTO automobiles (mark,model,gosnumber,client_id) VALUES ('BMW','M3','P444MP458rus',1);
INSERT INTO automobiles (mark,model,gosnumber,client_id) VALUES ('BMW','M4','P444MP459rus',1);

INSERT INTO automobiles (mark,model,gosnumber,client_id) VALUES ('AUDI','A4','A234PM33rus',2);

INSERT INTO services (name,price) VALUES ('Мойка автомобиля',500);
INSERT INTO services (name,price,description) VALUES ('Оклейка автомобиля антигравийной пленкой',12500,'Антигравийная полиуретановая пленка SunTek PPF состоит из 5 слоев, каждый из которых несет свою функцию. Главной отличительной особенностью полиуретановой пленки от виниловой является ее плотность.');
INSERT INTO services (name,price,description) VALUES ('test',12500,'dddd');


INSERT INTO employers (surname, name, patronym, phone, city, street, house, appartment) VALUES ('Зубова','Альбина','Артёмовна','8(777)434-22-11', 'Муром', 'Муромская', 14, 1);
INSERT INTO employers (surname, name, patronym, phone, city, street, house, appartment) VALUES ('Карасёв','Эдуард','Михайлович','8(777)434-22-12', 'Навашино', 'Московская', 16, 1);
INSERT INTO employers (surname, name, patronym, phone, city, street, house) VALUES ('Зубарев','Аркадий','Петрович','8(444)233-33-51', 'Москва', 'Московская', 19);
INSERT INTO employers (surname, name, patronym, phone, city, street, house) VALUES ('Зубарева','Альбина','Михайлович','8(444)233-33-52', 'Муром', 'Муромская', 22);

INSERT INTO providedservices (service_id, employer_id, automobile_id, dateofprovide) VALUES (1, 1, 1, '2020-02-19');
INSERT INTO providedservices (service_id, employer_id, automobile_id, dateofprovide) VALUES (1, 2, 1, '2024-02-19');
INSERT INTO providedservices (service_id, employer_id, automobile_id, dateofprovide) VALUES (2, 3, 2, '2021-02-19');
INSERT INTO providedservices (service_id, employer_id, automobile_id, dateofprovide) VALUES (2, 4, 2, '2022-02-19');
