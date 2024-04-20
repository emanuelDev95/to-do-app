CREATE DATABASE `toDo`

DROP TABLE IF EXISTS `statuses`;

CREATE TABLE `statuses` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `created_at` datetime(6) DEFAULT NULL,
                            `updated_at` datetime(6) DEFAULT NULL,
                            `estado` varchar(255) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `statuses` WRITE;

INSERT INTO `statuses` VALUES (1,NULL,NULL,'Pendiente');
INSERT INTO `statuses` VALUES (2,NULL,NULL,'Completada');

UNLOCK TABLES;



DROP TABLE IF EXISTS `tasks`;

CREATE TABLE `tasks` (
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `created_at` datetime(6) DEFAULT NULL,
                         `updated_at` datetime(6) DEFAULT NULL,
                         `description` varchar(255) DEFAULT NULL,
                         `due` datetime(6) DEFAULT NULL,
                         `title` varchar(255) DEFAULT NULL,
                         `status_id` bigint DEFAULT NULL,
                         PRIMARY KEY (`id`),
                         KEY `FKhp48vnj340wm1stg2kux5dqcx` (`status_id`),
                         CONSTRAINT `FKhp48vnj340wm1stg2kux5dqcx` FOREIGN KEY (`status_id`) REFERENCES `statuses` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

