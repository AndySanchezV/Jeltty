# Jeltty: Análisis  

## 📌 **Contexto de la Aplicación**  
### 🌍 **Mundo real del problema**  
- Muchas personas no mantienen un seguimiento de sus hábitos alimenticios, esta aplicación ayuda a visualizar el balance de macros.
- Las apps existentes son complejas y con funciones de pago que no valen realmente la pena.
- Las apps existentes suelen requerir una conexión a internet para cumplir sus funciones.

### 📱 **Aplicaciones ya existentes**  
1. **MyFitnessPal**:  
   - Base de datos amplia, pero requiere suscripción.
2. **FatSecret**:  
   - Aunque registra los hábitos alimenticios no cuenta con resúmenes semanales visuales.  
3. **Yazio**:  
   - Se centra en la creación de menús sin muchas más funciones.  

### 🚀 **¿Por qué "Jeltty" es mejor?**  
- **Registro simplificado**: Solo 4 categorías diarias (desayuno/almuerzo/cena/snacks) + notas. 
- **No requiere conexión continua**: Los datos se guardan localmente y se sincronizan después con la API.  
- **Resumen visual**: Gráficos semanales de macros (proteínas, grasas, carbohidratos).
- **Consultar historial alimenticio**: Permite consultar tu historial alimenticio.
- **Editar registros pasados**: Se puede corregir entradas incorrectas. 
---

## 🔍 **Casos de Uso**

### Actores Externos
| **Actor**       | **Caso de Uso**                          | **Descripción**                                   |  
|------------------|------------------------------------------|--------------------------------------------------|  
| **Usuario**      | Registrar comida diaria                  | Añade alimentos, pudiendo agregar notas.         |  
| **Usuario**      | Editar/Eliminar registros pasados        | Modifica entradas incorrectas.                   |  
| **API Externa (Spoonacular)**  | Sincronizar datos nutricionales          | Obtiene macros de la comida.   |  

---

## 📋 **Requisitos**  
### ⚙️ **Funcionales (F)**  
1. **F1**: Registro diario de comidas (desayuno/almuerzo/cena/snacks).  
2. **F2**: Visualización de macros por comida.  
3. **F3**: Edición/Eliminación de registros pasados.
5. **F5**: Resumen semanal con gráficos de barras (esta función se confirmará más adelante).  
6. **F6**: Conexión a API externa (Spoonacular) para obtener datos nutricionales.  

### 🛠️ **No Funcionales (NF)**  
1. **NF1**: Almacenamiento local.  
   - **Datos locales**:  
     - Registros diarios (fecha, tipo de comida, alimentos, notas...). 
2. **NF2**: Sincronización con API al recuperar conexión.  
3. **NF3**: UI intuitiva.  
4. **NF4**: Compatibilidad con Android +7.
5. **NF5**: Uso adecuado de permisos del dispositivo.

---

## 🔄 **Flujo de Datos Clave**  
1. **Base de Datos Local**:  
   - Uso de SQLite para registrar datos necesarios del usuario y de las comidas diarias.  
2. **API Externa**:  
   - Consultar la API para obtener los macros de los alimentos.
---
<br>
<br>

# 🎨 **Jeltty: Diseño Inicial**  
## 📱**Pantallas Principales** 
  1. **Home**: Registro rápido del día actual + resumen de macros.  
  2. **Historial**: Lista de días pasados. 
  4. **Gráficos**: Progreso semanal.

## 🔄 **Reutilización**
  - Fragmentos: Encabezar el nombre del Usuario en la parte superior.
  - Fragmentos: Mostrar la fecha actual

## 🎨 **Paleta de Colores Inicial**  
  - **Verde** (#4CAF50) para acciones saludables.  
  - **Azul** (#2196F3) para datos objetivos.
  - **Púrpura** (#9886cf) para mostrar datos en gráifcos.

## 📈 **Diagrama de despliegue Jeltty**
![Diagrama de despliegue] (docs/DiagramaDespliegue.png)
