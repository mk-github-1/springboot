--------------------------------------------------

-- Delete
DELETE FROM public.user_role;
DELETE FROM public.login_user;
DELETE FROM public.role;

DELETE FROM public.person;

--------------------------------------------------

-- role --
INSERT INTO public.role(id, name) VALUES(1, 'SYSTEM_ADMINISTRATOR');
INSERT INTO public.role(id, name) VALUES(2, 'ADMINISTRATOR');
INSERT INTO public.role(id, name) VALUES(3, 'USER');

--------------------------------------------------

-- login_user --
-- BCryptハッシュの計算 https://toolbase.cc/text/bcrypt : password 0000 --
INSERT INTO public.login_user(id, name, email, password) VALUES(1, 'system_administrator', 'adc@example.com', '$2a$08$X/YzqqMDYG0FylpR9uVep.3Ds2a3grpE8UPw/vfswWJT5kcLcSDBq');
INSERT INTO public.login_user(id, name, email, password) VALUES(2, 'administrator', 'adc@example.com', '$2a$08$X/YzqqMDYG0FylpR9uVep.3Ds2a3grpE8UPw/vfswWJT5kcLcSDBq');
INSERT INTO public.login_user(id, name, email, password) VALUES(3, 'user', 'adc@example.com', '$2a$08$X/YzqqMDYG0FylpR9uVep.3Ds2a3grpE8UPw/vfswWJT5kcLcSDBq');

--------------------------------------------------

-- user_role --
INSERT INTO public.user_role(user_id, role_id) VALUES(1, 1);
INSERT INTO public.user_role(user_id, role_id) VALUES(2, 2);
INSERT INTO public.user_role(user_id, role_id) VALUES(3, 3);

--------------------------------------------------

-- person ※日本語が文字化けしないか確認のためパーソンとしてます --
INSERT INTO public.person(id, name, age) VALUES(1, 'パーソン1', 20);
INSERT INTO public.person(id, name, age) VALUES(2, 'パーソン2', 21);
INSERT INTO public.person(id, name, age) VALUES(3, 'パーソン3', 22);

--------------------------------------------------000
