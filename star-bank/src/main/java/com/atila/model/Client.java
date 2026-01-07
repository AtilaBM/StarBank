package com.atila.model;

public class Client {

    private String name;
    private Integer age;
    private String cpf;
    private String phone;

    public Client(String name, Integer age, String cpf, String phone) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (age < 18 || age >= 100 || age == null) {
            throw new IllegalArgumentException("Invalid age");
        }
        if (cpf == null) {
            throw new IllegalArgumentException("Cpf cannot be null");
        }

        this.name = name;
        this.age = age;
        this.cpf = cpf;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        String line = "─".repeat(50);

        return String.format("""
                %s
                CLIENT INFORMATION
                %s
                Name  : %s
                Age   : %d years
                CPF   : %s
                Phone : %s
                %s""",
                line,
                line,
                name,
                age,
                formatCpf(cpf),
                formatPhone(phone),
                line);
    }

    private String formatCpf(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            return cpf;
        }
        return String.format("%s.%s.%s-%s",
                cpf.substring(0, 3),
                cpf.substring(3, 6),
                cpf.substring(6, 9),
                cpf.substring(9, 11));
    }

    private String formatPhone(String phone) {
        if (phone == null) {
            return "N/A";
        }
        // Remove caracteres não numéricos
        String digits = phone.replaceAll("[^0-9]", "");

        // Formato: (XX) XXXXX-XXXX ou (XX) XXXX-XXXX
        if (digits.length() == 11) {
            return String.format("(%s) %s-%s",
                    digits.substring(0, 2),
                    digits.substring(2, 7),
                    digits.substring(7, 11));
        } else if (digits.length() == 10) {
            return String.format("(%s) %s-%s",
                    digits.substring(0, 2),
                    digits.substring(2, 6),
                    digits.substring(6, 10));
        }
        return phone; // Retorna original se não estiver no formato esperado
    }

}
