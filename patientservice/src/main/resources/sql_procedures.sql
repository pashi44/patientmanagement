DELIMITER $$
DROP PROCEDURE IF EXISTS InsertPatientData$$

CREATE PROCEDURE InsertPatientData(IN num_rows INT)
BEGIN
    DECLARE i INT DEFAULT 1;
    DECLARE random_email VARCHAR(255);
    
    -- Start a transaction to make 10,000 rows upload instantly
    START TRANSACTION; 
    
    WHILE i <= num_rows DO
        IF i % 5 = 0 THEN
            SET random_email = CONCAT('prash_', (i % 10), '@gmail.com');
        ELSE
            SET random_email = CONCAT('user_', i, '@hotmail.com');
        END IF;

        INSERT IGNORE INTO patient_model (
            address, 
            date_of_birth, 
            email, 
            name, 
            registration_date
        ) 
        VALUES (
            CONCAT(i, ' Main St, City_', i),
            DATE(NOW() - INTERVAL (FLOOR(RAND() * 20000)) DAY),
            random_email,
            CONCAT('First_', i),
            CURDATE()
        );

        SET i = i + 1;
    END WHILE;
    
    COMMIT;
END$$
DELIMITER ;