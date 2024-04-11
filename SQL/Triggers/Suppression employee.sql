-- Suppression de l'utilisateur id 7

DELIMITER //
CREATE TRIGGER IF NOT EXISTS remove_employee
AFTER DELETE
ON employees
FOR EACH ROW
BEGIN
	INSERT INTO employee_audit_log (employee_id, action_type, action_timestamp, OLD_employee_name, OLD_salary, NEW_employee_name, NEW_salary)
		VALUES (OLD.employee_id, "DELETE", NOW(), OLD.employee_name, OLD.salary, NULL, NULL);
END;
//
DELIMITER ;

-- Ajout du nouvel employé
DELETE FROM employees WHERE employee_id = 3;