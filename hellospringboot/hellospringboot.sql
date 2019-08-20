use mytest;
CREATE TABLE `user` (
	`id` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `username` varchar(255) NOT NULL,
    `age` int(10) NOT NULL,
    `phone` bigint NOT NULL,
    `email` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
insert into `user` values(1,'赵(dev)',23,158,'3658561548@qq.com');
insert into `user` values(2,'钱(dev)',27,136,'3658561548@126.com');
insert into `user` values(3,'孙(dev)',31,159,'3658561548@163.com');
insert into `user` values(4,'李(dev)',35,130,'3658561548@sina.com');
select * from `user`;

CREATE TABLE `userdetails` (
	`id` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `uid` int(10) NOT NULL,
    `address` varchar(255) NOT NULL,
    `city` varchar(50) NOT NULL,
    `marry` bit NOT NULL,
    PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
insert into `userdetails` values(1,1,'中关村丹棱街','北京',1);
insert into `userdetails` values(2,2,'黄浦区中华路','上海',0);
insert into `userdetails` values(3,3,'一德路','广州',0);
insert into `userdetails` values(4,4,'福田区福华3路','深圳',1);
insert into `userdetails` values(5,5,'良乡大学城','北京',1);
insert into `userdetails` values(6,6,'拱辰大街','北京',1);
insert into `userdetails` values(7,7,'后厂村路','北京',1);
select * from userdetails;

CREATE TABLE `userposition` (
	`id` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `city` varchar(20) NOT NULL,
    `position` varchar(128) NOT NULL,
    `longitude` decimal(18,15) NOT NULL,
    `latitude` decimal(18,15) NOT NULL,
    PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
insert into `userposition` values(1,'北京市','回龙观新村中区', 116.310771,40.06263);
insert into `userposition` values(2,'北京市','金域华府', 116.310127,40.064379);
insert into `userposition` values(3,'北京市','融泽嘉园中区', 116.311962,40.064822);
insert into `userposition` values(4,'北京市','回龙观新村东区', 116.312541,40.063246);
insert into `userposition` values(5,'北京市','上地东里', 116.314168,40.033075);
select * from userposition;

select
*
    from userposition
    where longitude >= 116.28713880089022 and 
    longitude <=116.3341411991098 and 
    latitude >= 116.29265356788163 and 
    latitude <= 116.32862643211838;
    
    
    
    CREATE TABLE `userrelation` (
	`id` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `uid` int(10) NOT NULL,

    PRIMARY KEY (`id`)

)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `useraccount` (
	`id` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `username` varchar(255) NOT NULL,
    `age` int(10) NOT NULL,
    `phone` bigint NOT NULL,
    `email` varchar(255) NOT NULL,
    `account` varchar(100) NOT NULL UNIQUE,
    `pwd` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
insert into `useraccount` values(1,'赵(dev)',23,158,'qq@qq.com','test001','test001');
insert into `useraccount` values(2,'钱(dev)',27,136,'126@126.com','test002','test002');
insert into `useraccount` values(3,'孙(dev)',31,159,'163@163.com','test003','test003');
insert into `useraccount` values(4,'李(dev)',35,130,'sina@sina.com','test004','test004');
select * from `useraccount`;
 
 

    


