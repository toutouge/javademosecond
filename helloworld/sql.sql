/*create database mytest;
use mytest;
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;*/

/*DROP TABLE IF EXISTS `user1`;
CREATE TABLE `user1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `sex` bit NOT NULL,
  `createtime` datetime NOT NULL,
  primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into user1(name, sex, createtime) value('小赵',1,now());
insert into user1(name, sex, createtime) value('小钱',0,now());
insert into user1(name, sex, createtime) value('小孙',0,now());
insert into user1(name, sex, createtime) value('小李',1,now());
insert into user1(name, sex, createtime) value('小周',0,now());
insert into user1(name, sex, createtime) value('小吴',0,now());
insert into user1(name, sex, createtime) value('小郑',1,now());
insert into user1(name, sex, createtime) value('小王',0,now());

-- 2018/4/26
CREATE TABLE `user2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `sex` bit NOT NULL,
  `pw` varchar(500) NOT NULL,
  `createtime` datetime NOT NULL,
  primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 修改密码字段长度
*/

use mytest;
select * from user2;

