DELIMITER $$
CREATE TRIGGER generar_placas
BEFORE INSERT ON placas
FOR EACH ROW
BEGIN
  SET @letras = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
  SET NEW.serie = CONCAT(
    SUBSTRING(@letras, FLOOR(RAND() * 26) + 1, 1),
    SUBSTRING(@letras, FLOOR(RAND() * 26) + 1, 1),
    SUBSTRING(@letras, FLOOR(RAND() * 26) + 1, 1),
    '-',
    LPAD(FLOOR(RAND() * 1000), 3, '0')
  );
END$$
DELIMITER ;

