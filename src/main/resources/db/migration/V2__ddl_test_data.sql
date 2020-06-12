insert into role (name, id) values ('admin', (select nextval ('role_seq')));
insert into role (name, id) values ('user', (select nextval ('role_seq')));

insert into users (create_date, login, name, password, patronymic, surname, id)
    values ('10-10-20', 'admin', 'Admin', '$2y$12$5K4bgLDYFlRI5UR9dzUBHOv4cZ110CQWTIv5j7fDvndONoTtoayB2', 'Admin', 'Admin', (select nextval ('user_seq')));
insert into users (create_date, login, name, password, patronymic, surname, id)
    values ('10-10-20', 'user', 'User', '$2y$12$GgFxcu461arMUvRR0GHx3.z2x63jNj5XX2eWovoX1EeOUsvVwIhMa', 'User', 'User', (select nextval ('user_seq')));

insert into users_roles (users_id, roles_id)
    values ((SELECT id FROM users WHERE login = 'admin'), (SELECT id FROM role WHERE name = 'admin'));
insert into users_roles (users_id, roles_id)
    values ((SELECT id FROM users WHERE login = 'user'), (SELECT id FROM role WHERE name = 'user'));


insert into subject (name, id) values ('Информатика', (select nextval ('subject_seq')));
insert into subject (name, id) values ('Математика', (select nextval ('subject_seq')));

insert into competition (end_datetime, name, start_datetime, subject_id, user_id, id)
    values ('11-10-20', 'Олимпиада  школа №11', '10-10-20', (SELECT id FROM subject WHERE name = 'Информатика') , (SELECT id FROM users WHERE login = 'admin'), (select nextval ('competition_seq')));
insert into competition (end_datetime, name, start_datetime, subject_id, user_id, id)
    values ('11-10-20', 'Юный гений', '10-10-20', (SELECT id FROM subject WHERE name = 'Математика') , (SELECT id FROM users WHERE login = 'admin'), (select nextval ('competition_seq')));
insert into competition (end_datetime, name, start_datetime, subject_id, user_id, id)
    values ('11-10-20', 'Mr. Robot', '10-10-20', (SELECT id FROM subject WHERE name = 'Информатика') , (SELECT id FROM users WHERE login = 'admin'), (select nextval ('competition_seq')));

INSERT INTO "task" (id, description, task_type, competition_id) VALUES ((select nextval('task_seq')), 'что такое рекурсия?', 'ANSWERS', (select id from competition where name ='Mr. Robot'));
INSERT INTO "task" (id, description, task_type, competition_id) VALUES ((select nextval('task_seq')), 'Единицей измерения информации является:', 'ANSWERS', (select id from competition where name ='Mr. Robot'));
INSERT INTO "task" (id, description, task_type, competition_id) VALUES ((select nextval('task_seq')), 'Какая система счисления используется при представлении числа в памяти компьютера:', 'ANSWERS', (select id from competition where name ='Mr. Robot'));
INSERT INTO "task" (id, description, task_type, competition_id) VALUES ((select nextval('task_seq')), 'Какая из перечисленных ниже устройств является устройством ввода:', 'ANSWERS', (select id from competition where name ='Mr. Robot'));
INSERT INTO "task" (id, description, task_type, competition_id) VALUES ((select nextval('task_seq')), 'Обработку данных производит:', 'ANSWER', (select id from competition where name ='Mr. Robot'));
INSERT INTO "task" (id, description, task_type, competition_id) VALUES ((select nextval('task_seq')), 'Какую цифру надо поставить вместо точки 2468.13579, чтобы полученное число делилось на 9 нацело?', 'ANSWERS', (select id from competition where name ='Юный гений'));
INSERT INTO "task" (id, description, task_type, competition_id) VALUES ((select nextval('task_seq')), 'Сколько секунд содержится в 1 часе 160 минутах и 2 секундах?', 'ANSWERS', (select id from competition where name ='Юный гений'));
INSERT INTO "task" (id, description, task_type, competition_id) VALUES ((select nextval('task_seq')), 'Вычислите:  139*15 + 18*139 + 15*261 + 18*261.', 'ANSWER',(select id from competition where name ='Юный гений'));
INSERT INTO "task" (id, description, task_type, competition_id) VALUES ((select nextval('task_seq')), '26*25 – 25*24 + 24*23 - 23*22 - 19*5.', 'ANSWER', (select id from competition where name ='Юный гений'));
INSERT INTO "task" (id, description, task_type, competition_id) VALUES ((select nextval('task_seq')), 'Дано несколько натуральных чисел, сумма которых равна 77. Если каждое из этих чисел уменьшить на 4, то сумма новых чисел будет равна 53. Сколько чисел было дано?', 'ANSWER', (select id from competition where name ='Юный гений'));
INSERT INTO "task" (id, description, task_type, competition_id) VALUES ((select nextval('task_seq')), '5+5', 'ANSWER', (select id from competition where name ='Юный гений'));

INSERT INTO "answer" (id, answer, task_id) VALUES ((select nextval ('answer_seq')), 'процессор', (SELECT id FROM "task" WHERE description = 'Обработку данных производит:'));
INSERT INTO "answer" (id, answer, task_id) VALUES ((select nextval ('answer_seq')), '13200', (SELECT id FROM "task" WHERE description = 'Вычислите:  139*15 + 18*139 + 15*261 + 18*261.'));
INSERT INTO "answer" (id, answer, task_id) VALUES ((select nextval ('answer_seq')), '1', (SELECT id FROM "task" WHERE description = '26*25 – 25*24 + 24*23 - 23*22 - 19*5.'));
INSERT INTO "answer" (id, answer, task_id) VALUES ((select nextval ('answer_seq')), '6', (SELECT id FROM "task" WHERE description = 'Дано несколько натуральных чисел, сумма которых равна 77. Если каждое из этих чисел уменьшить на 4, то сумма новых чисел будет равна 53. Сколько чисел было дано?'));
INSERT INTO "answer" (id, answer, task_id) VALUES ((select nextval ('answer_seq')), '10', (SELECT id FROM "task" WHERE description = '5+5'));

-- INSERT INTO option (id, is_correct, option, task_id) VALUES ((select nextval ('option_seq'))), false , 'Вызов функции', (SELECT id FROM "task" WHERE description = 'что такое рекурсия?'));
-- INSERT INTO option (id, is_correct, option, task_id) VALUES ((select nextval ('option_seq'))), true, 'Рекурсивный вызов самого себя внутри тела функции', (SELECT id FROM "task" WHERE description = 'что такое рекурсия?'));
-- INSERT INTO option (id, is_correct, option, task_id) VALUES ((select nextval ('option_seq'))), false, 'Не знаю))))', (SELECT id FROM "task" WHERE description = 'что такое рекурсия?'));
-- INSERT INTO option (id, is_correct, option, task_id) VALUES ((select nextval ('option_seq'))), false, 'бод', (select id from  "task" where description='Единицей измерения информации является:'));
-- INSERT INTO option (id, is_correct, option, task_id) VALUES ((select nextval ('option_seq'))), true, 'бит', (select id from   "task" where description='Единицей измерения информации является:'));
-- INSERT INTO option (id, is_correct, option, task_id) VALUES ((select nextval ('option_seq'))), false, 'ампер', (select id from    "task" where description='Единицей измерения информации является:'));
-- INSERT INTO option (id, is_correct, option, task_id) VALUES ((select nextval ('option_seq'))), false, 'герц', (select id from "task" where description='Единицей измерения информации является:'));
-- INSERT INTO option (id, is_correct, option, task_id) VALUES ((select nextval ('option_seq'))), false, 'десятичная', (select  id from "task" where description='Какая система счисления используется при представлении числа в памяти компьютера:'));
-- INSERT INTO option (id, is_correct, option, task_id) VALUES ((select nextval ('option_seq'))), true, 'двоичная', (select  id from "task" where description='Какая система счисления используется при представлении числа в памяти компьютера:'));
-- INSERT INTO option (id, is_correct, option, task_id) VALUES ((select nextval ('option_seq'))), false, 'троичная', (select  id from "task" where description='Какая система счисления используется при представлении числа в памяти компьютера:'));
-- INSERT INTO option (id, is_correct, option, task_id) VALUES ((select nextval ('option_seq'))), false, 'шестидесятеричная', (select  id from "task" where description='Какая система счисления используется при представлении числа в памяти компьютера:'));
-- INSERT INTO option (id, is_correct, option, task_id) VALUES ((select nextval ('option_seq'))), true, 'клавиатура', (select id from "task" where description='Какая из перечисленных ниже устройств является устройством ввода:'));
-- INSERT INTO option (id, is_correct, option, task_id) VALUES ((select nextval ('option_seq'))), false, 'дискета', (select id from "task" where description='Какая из перечисленных ниже устройств является устройством ввода:'));
-- INSERT INTO option (id, is_correct, option, task_id) VALUES ((select nextval ('option_seq'))), false, 'дисплей', (select id from "task" where description='Какая из перечисленных ниже устройств является устройством ввода:'));
-- INSERT INTO option (id, is_correct, option, task_id) VALUES ((select nextval ('option_seq'))), false, '4', (select id from "task" where description='Какую цифру надо поставить вместо точки 2468.13579, чтобы полученное число делилось на 9 нацело?'));
-- INSERT INTO option (id, is_correct, option, task_id) VALUES ((select nextval ('option_seq'))), false, '2', (select id from "task" where description='Какую цифру надо поставить вместо точки 2468.13579, чтобы полученное число делилось на 9 нацело?'));
-- INSERT INTO option (id, is_correct, option, task_id) VALUES ((select nextval ('option_seq'))), false, '56', (select id from "task" where description='Какую цифру надо поставить вместо точки 2468.13579, чтобы полученное число делилось на 9 нацело?'));
-- INSERT INTO option (id, is_correct, option, task_id) VALUES ((select nextval ('option_seq'))), true, '0', (select id from "task" where description='Какую цифру надо поставить вместо точки 2468.13579, чтобы полученное число делилось на 9 нацело?'));
-- INSERT INTO option (id, is_correct, option, task_id) VALUES ((select nextval ('option_seq'))), true, '13202', (select if from "task" where description='Дано несколько натуральных чисел, сумма которых равна 77. Если каждое из этих чисел уменьшить на 4, то сумма новых чисел будет равна 53. Сколько чисел было дано?'));
-- INSERT INTO option (id, is_correct, option, task_id) VALUES ((select nextval ('option_seq'))), false, '12202', (select if from "task" where description='Дано несколько натуральных чисел, сумма которых равна 77. Если каждое из этих чисел уменьшить на 4, то сумма новых чисел будет равна 53. Сколько чисел было дано?'));
-- INSERT INTO option (id, is_correct, option, task_id) VALUES ((select nextval ('option_seq'))), false, '14202', (select if from "task" where description='Дано несколько натуральных чисел, сумма которых равна 77. Если каждое из этих чисел уменьшить на 4, то сумма новых чисел будет равна 53. Сколько чисел было дано?'));
-- INSERT INTO option (id, is_correct, option, task_id) VALUES ((select nextval ('option_seq'))), false, '106002', (select if from "task" where description='Дано несколько натуральных чисел, сумма которых равна 77. Если каждое из этих чисел уменьшить на 4, то сумма новых чисел будет равна 53. Сколько чисел было дано?'));
--



