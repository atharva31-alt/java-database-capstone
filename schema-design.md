# Hybrid Database Schema Design

## 1. MySQL Relational Schema (Database: cms)

### Admin Users Table
* **Table Name:** dmins
* **Fields:**
  * id (INT, Primary Key, Auto Increment)
  * username (VARCHAR(50), Unique, Not Null)
  * password (VARCHAR(255), Not Null)
  * email (VARCHAR(100), Unique, Not Null)

### Doctors Table
* **Table Name:** doctors
* **Fields:**
  * id (INT, Primary Key, Auto Increment)
  * 
ame (VARCHAR(100), Not Null)
  * specialization (VARCHAR(100), Not Null)
  * email (VARCHAR(100), Unique, Not Null)
  * password (VARCHAR(255), Not Null)

### Patients Table
* **Table Name:** patients
* **Fields:**
  * id (INT, Primary Key, Auto Increment)
  * 
ame (VARCHAR(100), Not Null)
  * email (VARCHAR(100), Unique, Not Null)
  * phone (VARCHAR(15))
  * medical_history_summary (TEXT)

### Appointments Table
* **Table Name:** ppointments
* **Fields:**
  * id (INT, Primary Key, Auto Increment)
  * patient_id (INT, Foreign Key referencing patients(id))
  * doctor_id (INT, Foreign Key referencing doctors(id))
  * ppointment_time (DATETIME, Not Null)
  * status (VARCHAR(20), Default 'SCHEDULED')

---

## 2. MongoDB Document Schema (Collection: prescriptions)

### Prescriptions Structure
`json
{
  "_id": "ObjectId",
  "appointment_id": "Number/Integer",
  "doctor_id": "Number/Integer",
  "patient_id": "Number/Integer",
  "prescription_date": "ISODate",
  "medications": [
    {
      "medicine_name": "String",
      "dosage": "String",
      "duration": "String"
    }
  ],
  "doctor_notes": "String (Optional)",
  "metadata": {
    "issued_at": "ISODate",
    "facility_code": "String"
  }
}
