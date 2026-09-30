# 🚗 Sistema de Alquiler de Vehículos de Movilidad Sostenible

Aplicación desarrollada en **Java** para la gestión integral de una empresa de alquiler de vehículos urbanos (Bicicletas, Patinetes y Motos). El proyecto destaca por una profunda aplicación del paradigma de **Programación Orientada a Objetos (POO)**.

## ⚙️ Arquitectura Técnica y Patrones Aplicados
* **Herencia y Polimorfismo:** Jerarquía robusta separando a los usuarios (`Admin`, `Mecanico`, `UsuarioPremium`, etc.) y vehículos (`MotoGrande`, `Patinete`, etc.) heredando de clases base abstractas.
* **Gestión de Memoria y Colecciones:** Uso extensivo de `ArrayList` para gestionar dinámicamente las flotas, historiales de clientes, bases de estacionamiento y colas de avisos de reparación.
* **Manejo del Tiempo:** Integración de la API `java.time` (`LocalDateTime`, `Duration`, `YearMonth`) para calcular la duración exacta de los alquileres y evaluar promociones basadas en el historial mensual.

## 🚀 Funcionalidades Principales
1. **Gestión de Alquileres y Tarifas:** Inicio, finalización y cálculo de tarifas dinámicas en función del tiempo de uso, tipo de vehículo y tipo de suscripción del cliente.
2. **Sistema de Mantenimiento:** Generación automática de tickets de avería y batería baja, enrutados directamente a los perfiles de `Mecanico` o `Mantenimiento` correspondientes.
3. **Reglas de Negocio Geográficas:** Implementación de un sistema de coordenadas (`Ubicacion`) con cálculo de distancias y restricciones espaciales (geovallas) para evitar que las motos finalicen trayectos fuera de la ciudad.
4. **Ascensos Automáticos:** Algoritmo que evalúa el historial del usuario estandar y lo asciende a `Premium` si cumple hitos de fidelidad (ej. usar todos los tipos de vehículos en los últimos 6 meses).

## 👩‍💻 Autora
**Yamina Abjil**
* Estudiante de Ingeniería Informática
* [LinkedIn](https://www.linkedin.com/in/yamina-abjil) | [GitHub](https://github.com/yaminaabjil)
