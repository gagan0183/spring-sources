CREATE PROCEDURE getEmployee
(
	IN id INTEGER,
	OUT Emp_Name VARCHAR(20),
	OUT Emp_Age INTEGER
)
BEGIN
	SELECT Name, Age
	INTO Emp_Name, Emp_Age
	FROM Employee where EmpId = id;
END;