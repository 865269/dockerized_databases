CREATE DATABASE IF NOT EXISTS inventory;

ALTER DATABASE inventory
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

GRANT ALL PRIVILEGES ON petclinic.* TO 'inventory'@'%' IDENTIFIED BY 'inventory';
