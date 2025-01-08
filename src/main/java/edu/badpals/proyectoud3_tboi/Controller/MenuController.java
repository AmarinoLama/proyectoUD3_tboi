    package edu.badpals.proyectoud3_tboi.Controller;
    
    import edu.badpals.proyectoud3_tboi.Model.Dao.ConsumibleDAO;
    import edu.badpals.proyectoud3_tboi.Model.Dao.ObjetoActivoDAO;
    import edu.badpals.proyectoud3_tboi.Model.Dao.ObjetoDAO;
    import edu.badpals.proyectoud3_tboi.Model.Dao.ObjetoPasivoDAO;
    import edu.badpals.proyectoud3_tboi.Model.Entity.*;
    import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.Parent;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.control.MenuButton;
    import javafx.scene.control.TableColumn;
    import javafx.scene.control.TableView;
    import javafx.scene.image.Image;
    import javafx.scene.image.ImageView;
    import javafx.scene.text.Text;
    import javafx.stage.Stage;
    import javafx.beans.property.SimpleObjectProperty;
    import java.util.List;
    import java.io.IOException;

    public class MenuController {
    
        @FXML
        private ImageView imgPersonaje;
    
        @FXML
        private Button btnAnadirItem;
    
        @FXML
        private Button btnCambiarPersonaje;
    
        @FXML
        private Button btnQuitarItem;
    
        @FXML
        private MenuButton mbtnHabitacion;
    
        @FXML
        private MenuButton mbtnTipoObjeto;
    
        @FXML
        private Text txtAlcance;
    
        @FXML
        private Text txtAtaque;
    
        @FXML
        private Text txtConsumible;
    
        @FXML
        private Text txtItemActivo;
    
        @FXML
        private Text txtLagrimas;
    
        @FXML
        private Text txtSuerte;
    
        @FXML
        private Text txtVelocidad;
    
        @FXML
        private Text txtVelocidadLagrimas;
    
        @FXML
        private Text txtVida;
    
        @FXML
        private TableView<Objeto> tablaObjetos;
    
        public void setImgPersonaje(String personaje) {
            imgPersonaje.setImage(new Image(getClass().getResource("/img/personajes/" + personaje + ".png").toExternalForm()));
        }
    
        @FXML
        public void initialize() {
            cargarPasivos();
        }
    
        @FXML
        void anadirItem(ActionEvent event) {
    
        }
    
        @FXML
        void quitarItem(ActionEvent event) {
    
        }
    
        public void filtrarPasivos(ActionEvent event) {
            cargarPasivos();
        }
    
        public void filtrarActivos(ActionEvent event) {
            cargarActivos();
        }
    
        public void filtrarConsumibles(ActionEvent event) {
            cargarConsumibles();
        }
    
        public void filtrarTodos(ActionEvent event) {
            cargarTodosObjetos();
        }
    
        @FXML
        void cambiarPersonaje(ActionEvent event) {
            cargarVentana();
        }
    
    
        public void cargarVentana() {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/seleccionPersonaje.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage newStage = new Stage();
                newStage.setTitle("The Binding of Isaac: Rebirth");
                newStage.setScene(scene);
                newStage.setResizable(false);
                newStage.show();
    
                Stage currentStage = (Stage) imgPersonaje.getScene().getWindow();
                currentStage.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    
        private void cargarPasivos() {
            ObjetoPasivoDAO objetoDAO = new ObjetoPasivoDAO();
            List<ObjetosPasivo> objetos = objetoDAO.getObjetosPasivos();
    
            // Limpiar las columnas existentes
            tablaObjetos.getColumns().clear();
    
            // Crear las columnas
            TableColumn<Objeto, Object> colId = new TableColumn<>("ID");
            TableColumn<Objeto, Object> colNombre = new TableColumn<>("Nombre");
            TableColumn<Objeto, Object> colEfecto = new TableColumn<>("Efecto");
            colEfecto.setMaxWidth(225);
            TableColumn<Objeto, Object> colDano = new TableColumn<>("Daño");
            TableColumn<Objeto, Object> colSalud = new TableColumn<>("Salud");
            TableColumn<Objeto, Object> colVelocidad = new TableColumn<>("Velocidad");
            TableColumn<Objeto, Object> colLagrimas = new TableColumn<>("Lágrimas");
            TableColumn<Objeto, Object> colVelocidadLagrimas = new TableColumn<>("V Lágrimas");
            TableColumn<Objeto, Object> colSuerte = new TableColumn<>("Suerte");
    
            // Asignar las propiedades correspondientes a cada columna
            colId.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getId()));
            colNombre.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNombre()));
            colEfecto.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getEfecto()));
    
            // Comprobar si el objeto es de tipo ObjetosPasivo
            colDano.setCellValueFactory(cellData -> {
                if (cellData.getValue() instanceof ObjetosPasivo) {
                    return new SimpleObjectProperty<>(((ObjetosPasivo) cellData.getValue()).getMejoraDano());
                }
                return null;
            });
    
            colSalud.setCellValueFactory(cellData -> {
                if (cellData.getValue() instanceof ObjetosPasivo) {
                    return new SimpleObjectProperty<>(((ObjetosPasivo) cellData.getValue()).getMejoraSalud());
                }
                return null;
            });
    
            colVelocidad.setCellValueFactory(cellData -> {
                if (cellData.getValue() instanceof ObjetosPasivo) {
                    return new SimpleObjectProperty<>(((ObjetosPasivo) cellData.getValue()).getMejoraVelocidad());
                }
                return null;
            });
    
            colLagrimas.setCellValueFactory(cellData -> {
                if (cellData.getValue() instanceof ObjetosPasivo) {
                    return new SimpleObjectProperty<>(((ObjetosPasivo) cellData.getValue()).getMejoraLagrimas());
                }
                return null;
            });
    
            colVelocidadLagrimas.setCellValueFactory(cellData -> {
                if (cellData.getValue() instanceof ObjetosPasivo) {
                    return new SimpleObjectProperty<>(((ObjetosPasivo) cellData.getValue()).getMejoraVelocidadProyectil());
                }
                return null;
            });
    
            colSuerte.setCellValueFactory(cellData -> {
                if (cellData.getValue() instanceof ObjetosPasivo) {
                    return new SimpleObjectProperty<>(((ObjetosPasivo) cellData.getValue()).getMejoraSuerte());
                }
                return null;
            });
    
            // Agregar las columnas a la tabla
            tablaObjetos.getColumns().addAll(colId, colNombre, colDano, colSalud, colVelocidad, colLagrimas, colVelocidadLagrimas, colSuerte, colEfecto);
    
            // Añadir los objetos a la tabla
            tablaObjetos.getItems().setAll(objetos);
        }
    
        private void cargarActivos() {
            ObjetoActivoDAO activoDAO = new ObjetoActivoDAO();
            List<ObjetosActivo> activos = activoDAO.getObjetosActivos();
    
            // Limpiar las columnas existentes
            tablaObjetos.getColumns().clear();
    
            // Crear las columnas
            TableColumn<Objeto, Object> colId = new TableColumn<>("ID");
            TableColumn<Objeto, Object> colNombre = new TableColumn<>("Nombre");
            TableColumn<Objeto, Object> colEfecto = new TableColumn<>("Efecto");
            TableColumn<Objeto, Object> colRecarga = new TableColumn<>("Tiempo Recarga");
    
            // Asignar las propiedades correspondientes a cada columna
            colId.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getId()));
            colNombre.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNombre()));
            colEfecto.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getEfecto()));
    
            // Comprobar si el objeto es de tipo Consumible
            colRecarga.setCellValueFactory(cellData -> {
                if (cellData.getValue() instanceof ObjetosActivo) {
                    return new SimpleObjectProperty<>(((ObjetosActivo) cellData.getValue()).getTiempoRecarga());
                }
                return null;
            });
    
            // Agregar las columnas a la tabla
            tablaObjetos.getColumns().addAll(colId, colNombre, colEfecto, colRecarga);
    
            // Añadir los objetos a la tabla
            tablaObjetos.getItems().setAll(activos);
        }
    
        private void cargarConsumibles() {
            ConsumibleDAO consumibleDAO = new ConsumibleDAO();
            List<Consumible> consumibles = consumibleDAO.getConsumibles();
    
            // Limpiar las columnas existentes
            tablaObjetos.getColumns().clear();
    
            // Crear las columnas
            TableColumn<Objeto, Object> colId = new TableColumn<>("ID");
            TableColumn<Objeto, Object> colNombre = new TableColumn<>("Nombre");
            TableColumn<Objeto, Object> colEfecto = new TableColumn<>("Efecto");
            TableColumn<Objeto, Object> colDuracion = new TableColumn<>("Duración");
    
            // Asignar las propiedades correspondientes a cada columna
            colId.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getId()));
            colNombre.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNombre()));
            colEfecto.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getEfecto()));
    
            // Comprobar si el objeto es de tipo Consumible
            colDuracion.setCellValueFactory(cellData -> {
                if (cellData.getValue() instanceof Consumible) {
                    return new SimpleObjectProperty<>(((Consumible) cellData.getValue()).getDuracionEfecto());
                }
                return null;
            });
    
            // Agregar las columnas a la tabla
            tablaObjetos.getColumns().addAll(colId, colNombre, colEfecto, colDuracion);
    
            // Añadir los objetos a la tabla
            tablaObjetos.getItems().setAll(consumibles);
        }

        private void cargarTodosObjetos() {
            ObjetoDAO objetoDAO = new ObjetoDAO();
            List<Objeto> objetos = objetoDAO.getObjetos();
            // Limpiar las columnas existentes
            tablaObjetos.getColumns().clear();

            // Crear las columnas
            TableColumn<Objeto, Object> colId = new TableColumn<>("ID");
            TableColumn<Objeto, Object> colNombre = new TableColumn<>("Nombre");
            TableColumn<Objeto, Object> colEfecto = new TableColumn<>("Efecto");

            // Asignar las propiedades correspondientes a cada columna
            colId.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getId()));
            colNombre.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNombre()));
            colEfecto.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getEfecto()));

            // Agregar las columnas a la tabla
            tablaObjetos.getColumns().addAll(colId, colNombre, colEfecto);

            // Añadir los resultados a la tabla
            tablaObjetos.getItems().setAll(objetos);
        }
    }