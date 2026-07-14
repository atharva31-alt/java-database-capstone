# Smart Clinic Management System - Database Schema Design

## 1. Database Architecture & Tables

### admins Table
Tracks system administrators authorized to manage staff accounts.
* `id` (INT, Primary Key, Auto Increment, Not Null)
* `username` (VARCHAR(50), Unique, Not Null)
* `password` (VARCHAR(255), Not Null)

### doctors Table
Stores clinical profiles for medical practitioners.
* `id` (INT, Primary Key, Auto Increment, Not Null)
* `name` (VARCHAR(100), Not Null)
* `specialization` (VARCHAR(100), Not Null)
* `email` (VARCHAR(100), Unique, Not Null)

### patients Table
Stores personal and administrative data for registered clinic clients.
* `id` (INT, Primary Key, Auto Increment, Not Null)
* `name` (VARCHAR(100), Not Null)
* `email` (VARCHAR(100), Unique, Not Null)
* `phone` (VARCHAR(20), Not Null)
* `medical_history_summary` (TEXT)

### appointments Table
Maps the relational scheduling allocations between patients and physicians.
* `id` (INT, Primary Key, Auto Increment, Not Null)
* `doctor_id` (INT, Not Null)
* `patient_id` (INT, Not Null)
* `appointment_date` (DATETIME, Not Null)
* `status` (VARCHAR(20), Not Null)

---

## 2. Relational Entity Mapping (Foreign Key Constraints)

To preserve transactional integrity across the system architecture, the schema implements the following explicit constraints:

1. **Appointments to Doctors Linkage:**
   * The `doctor_id` field in the `appointments` table acts as a **Foreign Key** referencing the `id` primary key of the `doctors` table.
   * *Constraint Definition:* `FOREIGN KEY (doctor_id) REFERENCES doctors(id) ON DELETE CASCADE`

2. **Appointments to Patients Linkage:**
   * The `patient_id` field in the `appointments` table acts as a **Foreign Key** referencing the `id` primary key of the `patients` table.
   * *Constraint Definition:* `FOREIGN KEY (patient_id) REFERENCES patients(id) ON DELETE CASCADE`
