CREATE TABLE work_time (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  worker_id bigint(20),
  work_date DATE,
  start_time TIME ,
  end_time TIME ,
  note varchar(2000),
  reg_user_id bigint(20),
  reg_date TIMESTAMP,
  mod_user_id bigint(20),
  mod_date TIMESTAMP,
  PRIMARY KEY (id)
);

CREATE TABLE app_role (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  description varchar(255) DEFAULT NULL,
  role_name varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE app_user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  first_name varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  username varchar(255) NOT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE user_role (
  user_id bigint(20) NOT NULL,
  role_id bigint(20) NOT NULL,
  CONSTRAINT FK859n2jvi8ivhui0rl0esws6o FOREIGN KEY (user_id) REFERENCES app_user (id),
  CONSTRAINT FKa68196081fvovjhkek5m97n3y FOREIGN KEY (role_id) REFERENCES app_role (id)
);