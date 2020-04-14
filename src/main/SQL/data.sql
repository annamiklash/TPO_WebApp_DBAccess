insert into users (id, username, password)
values (1, 'hello', 'myPassword'),
(2, 'aaa', 'aaapassword'),
(3, 'bb', 'cream'),
(4, 'user1', 'qwerty');

insert into resources (id, name, content)
values (1, 'res1', 'http://www.movenowthinklater.com/'),
(2, 'res2', 'https://weirdorconfusing.com/'),
(3, 'res3', 'http://eelslap.com/'),
(4, 'res4', 'http://corndog.io/'),
(5, 'res5', 'https://cat-bounce.com/'),
(6, 'res6', 'http://ninjaflex.com/'),
(7, 'res7', 'http://beesbeesbees.com/'),
(8, 'res8', 'https://pointerpointer.com/'),
(9, 'res9', 'http://ihasabucket.com/'),
(10, 'res10', 'http://www.rrrgggbbb.com/'),
(11, 'res11', 'http://www.yesnoif.com/'),
(12, 'res12', 'https://corgiorgy.com/');
-- End of file.

insert into users_resources (users_id, resources_id)
VALUES
(1,1),
(2,2),
(3,3),
(4,4),
(1,5),
(2,6),
(3,7),
(4,8),
(1,9),
(2,10),
(3,11),
(4,12),
(2,8),
(3,6),
(4,7),
(2,9),
(3,1),
(1,12);

