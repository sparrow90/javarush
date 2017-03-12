create table test.users (
  id int auto_increment primary key,
  name varchar(100),
  age int,
  admin bit default 0,
  cdate datetime);