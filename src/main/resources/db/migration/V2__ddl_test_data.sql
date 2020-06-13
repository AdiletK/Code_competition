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

INSERT INTO public.competition (id, end_datetime, name, start_datetime, subject_id, user_id)
 VALUES ((select nextval ('competition_seq')), '2020-11-10 00:00:00.000000', 'Mr. Robot', '2020-10-10 00:00:00.000000', (SELECT id FROM subject WHERE name = 'Информатика'), (SELECT id FROM users WHERE login = 'admin'));
INSERT INTO public.competition (id, end_datetime, name, start_datetime, subject_id, user_id)
 VALUES ((select nextval ('competition_seq')), '2020-11-10 00:00:00.000000', 'Олимпиада  (тест)', '2020-10-10 00:00:00.000000', (SELECT id FROM subject WHERE name = 'Информатика'), (SELECT id FROM users WHERE login = 'admin'));
INSERT INTO public.competition (id, end_datetime, name, start_datetime, subject_id, user_id)
 VALUES ((select nextval ('competition_seq')), '2020-11-10 00:00:00.000000', 'Олимпиада  (свой ответ)', '2020-10-10 00:00:00.000000', (SELECT id FROM subject WHERE name = 'Математика'), (SELECT id FROM users WHERE login = 'admin'));

INSERT INTO public.task (id, description, task_type, competition_id) VALUES ((select nextval('task_seq')), 'что такое рекурсия?', 'ANSWERS', (select id from competition where name ='Олимпиада  (тест)'));
INSERT INTO public.task (id, description, task_type, competition_id) VALUES ((select nextval('task_seq')), 'Единицей измерения информации является:', 'ANSWERS', (select id from competition where name ='Олимпиада  (тест)'));
INSERT INTO public.task (id, description, task_type, competition_id) VALUES ((select nextval('task_seq')), 'Какая система счисления используется при представлении числа в памяти компьютера:', 'ANSWERS', (select id from competition where name ='Олимпиада  (тест)'));
INSERT INTO public.task (id, description, task_type, competition_id) VALUES ((select nextval('task_seq')), 'Какая из перечисленных ниже устройств является устройством ввода:', 'ANSWERS', (select id from competition where name ='Олимпиада  (тест)'));
INSERT INTO public.task (id, description, task_type, competition_id) VALUES ((select nextval('task_seq')), 'Обработку данных производит:', 'ANSWER', (select id from competition where name ='Mr. Robot'));
INSERT INTO public.task (id, description, task_type, competition_id) VALUES ((select nextval('task_seq')), 'Структура компьютера — это:', 'ANSWERS', (select id from competition where name ='Mr. Robot'));
INSERT INTO public.task (id, description, task_type, competition_id) VALUES ((select nextval('task_seq')), 'Основная функция ЭВМ:', 'ANSWERS', (select id from competition where name ='Mr. Robot'));
INSERT INTO public.task (id, description, task_type, competition_id) VALUES ((select nextval('task_seq')), ' Персональный компьютер состоит из:', 'ANSWERS', (select id from competition where name ='Mr. Robot'));
INSERT INTO public.task (id, description, task_type, competition_id) VALUES ((select nextval('task_seq')), 'Системный блок включает в себя:', 'ANSWERS', (select id from competition where name ='Mr. Robot'));
INSERT INTO public.task (id, description, task_type, competition_id) VALUES ((select nextval('task_seq')), 'Микропроцессор предназначен для:', 'ANSWERS', (select id from competition where name ='Mr. Robot'));
INSERT INTO public.task (id, description, task_type, competition_id) VALUES ((select nextval('task_seq')), 'Разрядность микропроцессора — это:', 'ANSWERS', (select id from competition where name ='Mr. Robot'));
INSERT INTO public.task (id, description, task_type, competition_id) VALUES ((select nextval('task_seq')), 'От разрядности микропроцессора зависит:', 'ANSWERS', (select id from competition where name ='Mr. Robot'));
INSERT INTO public.task (id, description, task_type, competition_id) VALUES ((select nextval('task_seq')), 'Тактовая частота микропроцессора измеряется в:', 'ANSWERS', (select id from competition where name ='Mr. Robot'));
INSERT INTO public.task (id, description, task_type, competition_id) VALUES ((select nextval('task_seq')), ' Функции процессора состоят в', 'ANSWERS', (select id from competition where name ='Mr. Robot'));
INSERT INTO public.task (id, description, task_type, competition_id) VALUES ((select nextval('task_seq')), 'Микропроцессоры различаются между собой:', 'ANSWERS', (select id from competition where name ='Mr. Robot'));
INSERT INTO public.task (id, description, task_type, competition_id) VALUES ((select nextval('task_seq')), 'Сколько нужно минут (округлить до целых с избытком), чтобы переслать 152 Мегабайт со скоростью 20 килобайт/сек.?', 'ANSWER', (select id from competition where name ='Олимпиада  (свой ответ)'));
INSERT INTO public.task (id, description, task_type, competition_id) VALUES ((select nextval('task_seq')), 'Найти ширину самого узкого целочисленного интервала, содержащего все частные y/x для x[6,9],  y[20, 50]', 'ANSWER', (select id from competition where name ='Олимпиада  (свой ответ)'));

INSERT INTO public.answer (id, answer, task_id) VALUES ((select nextval ('answer_seq')), 'процессор', (SELECT id FROM "task" WHERE description = 'Обработку данных производит:'));
INSERT INTO public.answer (id, answer, task_id) VALUES ((select nextval ('answer_seq')), '130', (SELECT id FROM "task" WHERE description = 'Сколько нужно минут (округлить до целых с избытком), чтобы переслать 152 Мегабайт со скоростью 20 килобайт/сек.?'));
INSERT INTO public.answer (id, answer, task_id) VALUES ((select nextval ('answer_seq')), '7', (SELECT id FROM "task" WHERE description = 'Найти ширину самого узкого целочисленного интервала, содержащего все частные y/x для x[6,9],  y[20, 50]'));




-- INSERT INTO public.option (id, is_correct, option, task_id) VALUES (1, false, 'комплекс электронных устройств, осуществляющих обработку информации', 12);
-- INSERT INTO public.option (id, is_correct, option, task_id) VALUES (2, true, 'некоторая модель, устанавливающая состав, по- рядок и принципы взаимодействия входящих в нее компонентов', 12);
-- INSERT INTO public.option (id, is_correct, option, task_id) VALUES (3, false, 'комплекс программных и аппаратных средств.', 12);
-- INSERT INTO public.option (id, is_correct, option, task_id) VALUES (4, false, 'общение человека и машины', 13);
-- INSERT INTO public.option (id, is_correct, option, task_id) VALUES (5, false, 'разработка задач', 13);
-- INSERT INTO public.option (id, is_correct, option, task_id) VALUES (6, true, 'принцип программного управления.', 13);
-- INSERT INTO public.option (id, is_correct, option, task_id) VALUES (8, false, 'дополнительных устройств', 14);
-- INSERT INTO public.option (id, is_correct, option, task_id) VALUES (7, true, 'системного блока', 14);
-- INSERT INTO public.option (id, is_correct, option, task_id) VALUES (9, false, 'комплекса мультимедиа.', 14);
-- INSERT INTO public.option (id, is_correct, option, task_id) VALUES (10, true, 'системную плату', 15);
-- INSERT INTO public.option (id, is_correct, option, task_id) VALUES (11, false, 'модулятор-демодулятор', 15);
-- INSERT INTO public.option (id, is_correct, option, task_id) VALUES (12, false, ' средства связи и коммуникаций.', 15);
-- INSERT INTO public.option (id, is_correct, option, task_id) VALUES (13, true, 'управления работой компьютера и обработки данных', 16);
-- INSERT INTO public.option (id, is_correct, option, task_id) VALUES (14, false, 'управления работой компьютера и обработки данных', 16);
-- INSERT INTO public.option (id, is_correct, option, task_id) VALUES (15, false, 'обработки текстовых данных.', 16);
-- INSERT INTO public.option (id, is_correct, option, task_id) VALUES (16, false, 'наибольшая единица информации', 17);
-- INSERT INTO public.option (id, is_correct, option, task_id) VALUES (17, true, ' количество битов, которое воспринимается микропроцессором как единое целое', 17);
-- INSERT INTO public.option (id, is_correct, option, task_id) VALUES (18, false, ' наименьшая единица информации.', 17);
-- INSERT INTO public.option (id, is_correct, option, task_id) VALUES (19, false, 'количество используемых внешних устройств', 18);
-- INSERT INTO public.option (id, is_correct, option, task_id) VALUES (20, false, ' возможность подключения к сети', 18);
-- INSERT INTO public.option (id, is_correct, option, task_id) VALUES (21, true, 'максимальный объем внутренней памяти и производительность компьютера.', 18);
-- INSERT INTO public.option (id, is_correct, option, task_id) VALUES (22, true, 'мегагерцах', 19);
-- INSERT INTO public.option (id, is_correct, option, task_id) VALUES (23, false, 'кодах таблицы символов', 19);
-- INSERT INTO public.option (id, is_correct, option, task_id) VALUES (24, false, 'байтах и битах.', 19);
-- INSERT INTO public.option (id, is_correct, option, task_id) VALUES (25, false, 'подключении ЭВМ к электронной сети', 20);
-- INSERT INTO public.option (id, is_correct, option, task_id) VALUES (26, true, ' обработке данных, вводимых в ЭВМ', 20);
-- INSERT INTO public.option (id, is_correct, option, task_id) VALUES (27, false, 'выводе данных на печать.', 20);
-- INSERT INTO public.option (id, is_correct, option, task_id) VALUES (28, false, 'устройствами ввода и вывода', 21);
-- INSERT INTO public.option (id, is_correct, option, task_id) VALUES (29, true, 'разрядностью и тактовой частотой', 21);
-- INSERT INTO public.option (id, is_correct, option, task_id) VALUES (30, false, ' счетчиками времени.', 21);

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



