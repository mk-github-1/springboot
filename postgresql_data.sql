--------------------------------------------------

-- Delete
DELETE FROM public.user_role;
DELETE FROM public.login_user;
DELETE FROM public.role;

DELETE FROM public.person;

--------------------------------------------------

-- role --
INSERT INTO public.role(name, created_at, updated_at) VALUES('SYSTEM_ADMINISTRATOR', current_timestamp, current_timestamp);
INSERT INTO public.role(name, created_at, updated_at) VALUES('ADMINISTRATOR', current_timestamp, current_timestamp);
INSERT INTO public.role(name, created_at, updated_at) VALUES('USER', current_timestamp, current_timestamp);

--------------------------------------------------

-- login_user --
-- BCryptハッシュの計算 https://toolbase.cc/text/bcrypt : password 0000 --
INSERT INTO public.login_user(email, name, password, created_at, updated_at) VALUES('system_administrator@example.com', 'system_administrator', '$2a$08$X/YzqqMDYG0FylpR9uVep.3Ds2a3grpE8UPw/vfswWJT5kcLcSDBq', current_timestamp, current_timestamp);
INSERT INTO public.login_user(email, name, password, created_at, updated_at) VALUES('administrator@example.com', 'administrator', '$2a$08$X/YzqqMDYG0FylpR9uVep.3Ds2a3grpE8UPw/vfswWJT5kcLcSDBq', current_timestamp, current_timestamp);
INSERT INTO public.login_user(email, name, password, created_at, updated_at) VALUES('user@example.com', 'user', '$2a$08$X/YzqqMDYG0FylpR9uVep.3Ds2a3grpE8UPw/vfswWJT5kcLcSDBq', current_timestamp, current_timestamp);

--------------------------------------------------

-- user_role （Springではロールに”ROLE_”プレフィックスを設定する必要があります）--
INSERT INTO public.user_role(user_id, role_id, created_at, updated_at) VALUES('system_administrator@example.com', 'ROLE_SYSTEMADMINISTRATOR', current_timestamp, current_timestamp);
INSERT INTO public.user_role(user_id, role_id, created_at, updated_at) VALUES('administrator@example.com', 'ROLE_ADMINISTRATOR', current_timestamp, current_timestamp);
INSERT INTO public.user_role(user_id, role_id, created_at, updated_at) VALUES('user@example.com', 'ROLE_USER', current_timestamp, current_timestamp);

--------------------------------------------------

-- person ※日本語が文字化けしないか確認のためパーソンとしてます --
INSERT INTO public.person(id, name, email, age, remarks, old_id, "order", created_at, updated_at) VALUES(1, 'パーソン1', 'person1@example.com', 20, NULL, NULL, 1, current_timestamp, current_timestamp);
INSERT INTO public.person(id, name, email, age, remarks, old_id, "order", created_at, updated_at) VALUES(2, 'パーソン2', 'person2@example.com', 21, NULL, NULL, 2, current_timestamp, current_timestamp);
INSERT INTO public.person(id, name, email, age, remarks, old_id, "order", created_at, updated_at) VALUES(3, 'パーソン3', 'person3@example.com', 22, NULL, NULL, 3, current_timestamp, current_timestamp);

--------------------------------------------------
