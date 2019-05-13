CREATE TABLE IF NOT EXISTS visitor(id INTEGER PRIMARY KEY AUTOINCREMENT,v_name TEXT,email TEXT,company TEXT, arrivaldate TEXT, cardnumber TEXT, img TEXT);
INSERT or IGNORE INTO visitor VALUES (1, 'Adam', 'kika@gmail.com','Role Support Co., Ltd', '2019-04-30 12:15', '123456789', 'https://pbs.twimg.com/profile_images/858987821394210817/oMccbXv6_bigger.jpg');
-- INSERT or IGNORE INTO visitor VALUES (1, 'Simon', '', 'https://pbs.twimg.com/profile_images/858987821394210817/oMccbXv6_bigger.jpg');
-- INSERT or IGNORE INTO visitor VALUES (2, 'Max', '', 'https://pbs.twimg.com/profile_images/953978653624455170/j91_AYfd_400x400.jpg');
-- INSERT or IGNORE INTO visitor VALUES (3, 'Ben', '', 'https://pbs.twimg.com/profile_images/1060037170688417792/vZ7iAWXV_400x400.jpg');