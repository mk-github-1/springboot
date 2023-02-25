--------------------------------------------------

-- Delete
DELETE FROM public.user_role;
DELETE FROM public.login_user;
DELETE FROM public.role;

DELETE FROM public.person;

--------------------------------------------------

-- role --
INSERT INTO public.role(name) VALUES('SYSTEM_ADMINISTRATOR');
INSERT INTO public.role(name) VALUES('ADMINISTRATOR');
INSERT INTO public.role(name) VALUES('USER');

--------------------------------------------------

-- login_user --
-- BCryptハッシュの計算 https://toolbase.cc/text/bcrypt : password 0000 --
INSERT INTO public.login_user(email, name, password) VALUES('system_administrator@example.com', 'system_administrator', '$2a$08$X/YzqqMDYG0FylpR9uVep.3Ds2a3grpE8UPw/vfswWJT5kcLcSDBq');
INSERT INTO public.login_user(email, name, password) VALUES('administrator@example.com', 'administrator', '$2a$08$X/YzqqMDYG0FylpR9uVep.3Ds2a3grpE8UPw/vfswWJT5kcLcSDBq');
INSERT INTO public.login_user(email, name, password) VALUES('user@example.com', 'user', '$2a$08$X/YzqqMDYG0FylpR9uVep.3Ds2a3grpE8UPw/vfswWJT5kcLcSDBq');

--------------------------------------------------

-- user_role --
INSERT INTO public.user_role(user_id, role_id) VALUES('system_administrator@example.com', 'SYSTEM_ADMINISTRATOR');
INSERT INTO public.user_role(user_id, role_id) VALUES('administrator@example.com', 'ADMINISTRATOR');
INSERT INTO public.user_role(user_id, role_id) VALUES('user@example.com', 'USER');

--------------------------------------------------

-- person ※日本語が文字化けしないか確認のためパーソンとしてます --
INSERT INTO public.person(id, name, age) VALUES(1, 'パーソン1', 20);
INSERT INTO public.person(id, name, age) VALUES(2, 'パーソン2', 21);
INSERT INTO public.person(id, name, age) VALUES(3, 'パーソン3', 22);

--------------------------------------------------000
