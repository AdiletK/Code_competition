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


insert into subject (name, id) values ('IT', (select nextval ('subject_seq')));
insert into subject (name, id) values ('Math', (select nextval ('subject_seq')));

insert into competition (end_datetime, name, start_datetime, subject_id, user_id, id)
    values ('11-10-20', 'Olymp', '10-10-20', (SELECT id FROM subject WHERE name = 'IT') , (SELECT id FROM users WHERE login = 'admin'), (select nextval ('competition_seq')));
insert into competition (end_datetime, name, start_datetime, subject_id, user_id, id)
    values ('11-10-20', 'Olymp1', '10-10-20', (SELECT id FROM subject WHERE name = 'Math') , (SELECT id FROM users WHERE login = 'admin'), (select nextval ('competition_seq')));

insert into "task" (competition_id, description, task_type, id)
    values ((select id from competition where name ='Olymp'), 'Write calculator?', 'CODE', (select nextval ('task_seq')));
insert into "task" (competition_id, description, task_type, id)
    values ((select id from competition where name ='Olymp1'), 'what is Git ?', 'ANSWERS', (select nextval ('task_seq')));
    insert into "task" (competition_id, description, task_type, id)
    values ((select id from competition where name ='Olymp1'), '5+5', 'ANSWER', (select nextval ('task_seq')));

insert into source_code (memory_limit, task_id, time_limit, id)
    values (100, 1, 100, (select nextval ('source_code_seq')));

insert into answer (answer, task_id, id)
    values (100, 3, (select nextval ('answer_seq')));

insert into "option" (is_correct,"option", task_id, id)
    values (true,'Source control system', 2, (select nextval ('option_seq')));
insert into "option" (is_correct,"option", task_id, id)
    values (false ,'cloud drive', 2, (select nextval ('option_seq')));
insert into "option" (is_correct,"option", task_id, id)
    values (false ,'test', 2, (select nextval ('option_seq')));


insert into test (input, output, source_code_id, id)
    values ('1 2', '3',(SELECT id FROM source_code WHERE id = 1) , (select nextval ('test_seq')));
insert into test (input, output, source_code_id, id)
    values ('2 2', '4',(SELECT id FROM source_code WHERE id = 1) , (select nextval ('test_seq')));
