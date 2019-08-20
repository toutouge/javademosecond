use mytest;
CREATE TABLE `message` (
	`id` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `command` varchar(30) NOT NULL,
    `description` varchar(30) NOT NULL,
    `content` varchar(30) NOT NULL,
    PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

select * from message;

CREATE TABLE `userinfo` (
	`id` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `sex` bit NOT NULL,
    `name` varchar(20) NOT NULL,
    `pw` varchar(500) NOT NULL,
    `createtime` datetime NOT NULL,
    PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

select * from userinfo;
