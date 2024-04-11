-- Modifier le salaire de l'employé id 4

DELIMITER //
CREATE TRIGGER IF NOT EXISTS update_employee
AFTER UPDATE
ON employees
FOR EACH ROW
BEGIN
	INSERT INTO employee_audit_log (employee_id, action_type, action_timestamp, OLD_employee_name, OLD_salary, NEW_employee_name, NEW_salary)
		VALUES (NEW.employee_id, "UPDATE", NOW(), OLD.employee_name, OLD.salary, NEW.employee_name, NEW.salary);
END;
//
DELIMITER ;

UPDATE employees 
	SET salary = 50.98 WHERE employee_id = 4;