package edu.badpals.proyectoud3_tboi.Controller;

import edu.badpals.proyectoud3_tboi.Model.Dao.*;
import edu.badpals.proyectoud3_tboi.Model.Entity.*;
import edu.badpals.proyectoud3_tboi.View.Alertas;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.beans.property.SimpleObjectProperty;

import java.util.List;
import java.io.IOException;

public class MenuController {

    @FXML
    public Button btnInsertar;

    @FXML
    public Button btnModificar;

    @FXML
    public Button btnEliminar;

    @FXML
    public Text txtCodigoPromocion;

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

    @FXML
    private TableView<Objeto> tblInventario;

    private static Personaje personajeActual;

    // SETTERS DE LA GESTIÓN DE PERSONAJES

    public static void setPersonajeActual(Personaje personaje) {
        personajeActual = personaje;
    }

    public void setImgPersonaje(String personaje) {
        imgPersonaje.setImage(new Image(getClass().getResource("/img/personajes/" + personaje + ".png").toExternalForm()));
    }

    // FUNCIONES DEL FXML

    // COMENTARIO EXAMEN: llamar a la función desde el initialize

    @FXML
    public void initialize() {
        cargarPasivos();
        mbtnHabitacion.setDisable(true);
        desactivarBotonesConsumible();
        cargarCodigoPromocional();
    }

    @FXML
    void anadirItem(ActionEvent event) {
        Objeto selectedObjeto = tablaObjetos.getSelectionModel().getSelectedItem();
        if (selectedObjeto != null) {
            PersonajeDAO personajeDAO = new PersonajeDAO();

            Integer idObjeto = selectedObjeto.getId();
            Integer idPersonaje = personajeDAO.seleccionarIDpersonaje();

            TableColumn<Objeto, ?> cuartaCol = tablaObjetos.getColumns().get(2);
            String nombreCuartaColumna = cuartaCol.getText();
            switch (nombreCuartaColumna) {
                case "Salud":
                    personajeDAO.addObjetoPasivoToPersonaje(idPersonaje, idObjeto);
                    ObjetosPasivo objetoPasivo = personajeDAO.getObjetoPasivo(idObjeto);
                    mejorarEstadisticas(objetoPasivo);
                    break;
                case "Tiempo Recarga":
                    personajeDAO.addObjetoActivoToPersonaje(idPersonaje, idObjeto);
                    break;
                case "Duración":
                    personajeDAO.addConsumibleToPersonaje(idPersonaje, idObjeto);
                    break;
            }
        } else {
            Alertas.showNadaSeleccionado();
        }

        cargarActivoActual();
        cargarConsumibleActual();
        cargarObjetosInventario();
    }

    @FXML
    void quitarItem(ActionEvent event) {
        PersonajeDAO personajeDAO = new PersonajeDAO();
        int idPersonaje = personajeDAO.seleccionarIDpersonaje();
        int idObjeto = tablaObjetos.getSelectionModel().getSelectedItem().getId();
        personajeDAO.eliminarItemDePersonaje(idPersonaje, idObjeto);

        cargarActivoActual();
        cargarConsumibleActual();
        cargarObjetosInventario();
    }

    @FXML
    public void filtrarPasivos(ActionEvent event) {
        cargarPasivos();
        activarBotonesInventario();
        desactivarBotonesConsumible();
        mbtnTipoObjeto.setText("Pasivos");
        mbtnHabitacion.setDisable(true);
    }

    @FXML
    public void filtrarActivos(ActionEvent event) {
        cargarActivos();
        activarBotonesInventario();
        desactivarBotonesConsumible();
        mbtnTipoObjeto.setText("Activos");
        mbtnHabitacion.setDisable(true);
    }

    @FXML
    public void filtrarConsumibles(ActionEvent event) {
        cargarConsumibles();
        activarBotonesInventario();
        activarBotonesConsumible();
        mbtnTipoObjeto.setText("Consumibles");
        mbtnHabitacion.setDisable(true);
    }

    @FXML
    public void filtrarTodos(ActionEvent event) {
        cargarTodosObjetos();
        desactivarBotonesInventario();
        desactivarBotonesConsumible();
        mbtnTipoObjeto.setText("Todos objetos");
        mbtnHabitacion.setDisable(false);
    }

    @FXML
    void cambiarPersonaje(ActionEvent event) {
        Alertas.showInfo("Cambio de personaje", "Se ha cambiado de personaje correctamente y se ha borrado el anterior");
        cargarVentana();
    }

    @FXML
    public void filtrarTesoro(ActionEvent event) {
        mbtnHabitacion.setText("Tesoro");
        cargarFiltradoPool();
    }

    @FXML
    public void filtrarJefe(ActionEvent event) {
        mbtnHabitacion.setText("Jefe");
        cargarFiltradoPool();
    }

    @FXML
    public void filtrarTienda(ActionEvent event) {
        mbtnHabitacion.setText("Tienda");
        cargarFiltradoPool();
    }

    @FXML
    public void filtrarAngel(ActionEvent event) {
        mbtnHabitacion.setText("Angelical");
        cargarFiltradoPool();
    }

    @FXML
    public void filtrarDemonio(ActionEvent event) {
        mbtnHabitacion.setText("Demoniaca");
        cargarFiltradoPool();
    }

    @FXML
    public void filtrarSecreta(ActionEvent event) {
        mbtnHabitacion.setText("Secreta");
        cargarFiltradoPool();
    }

    @FXML
    public void abrirMenuInsertar(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/crearConsumible.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Añadir Datos");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
            cargarConsumibles();
        } catch (IOException e) {
            Alertas.showError("Error al cargar ventana", "Ha sucedido un problema al cargar la ventana");
        }
    }

    @FXML
    public void abrirMenuModificar(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/modificarConsumible.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Añadir Datos");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
            cargarConsumibles();
        } catch (IOException e) {
            Alertas.showError("Error al cargar ventana", "Ha sucedido un problema al cargar la ventana");
        }
    }

    @FXML
    public void abrirMenuEliminar(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/borrarConsumible.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Añadir Datos");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
            cargarConsumibles();
        } catch (IOException e) {
            Alertas.showError("Error al cargar ventana", "Ha sucedido un problema al cargar la ventana");
        }
    }

    // FUNCIONES DE ESTADÍSTICAS

    private void mejorarEstadisticas(ObjetosPasivo op) {
        Float multiplicadorDano = personajeActual.getMultiplicadorDano();
        txtAtaque.setText(String.format("%.2f", Float.parseFloat(txtAtaque.getText().replace(",", ".")) + (op.getMejoraDano()) * multiplicadorDano).replace(".", ","));
        txtVelocidad.setText(String.format("%.2f", Float.parseFloat(txtVelocidad.getText().replace(",", ".")) + op.getMejoraVelocidad()).replace(".", ","));
        txtLagrimas.setText(String.format("%.2f", Float.parseFloat(txtLagrimas.getText().replace(",", ".")) + op.getMejoraLagrimas()).replace(".", ","));
        txtVida.setText(String.format("%.2f", Float.parseFloat(txtVida.getText().replace(",", ".")) + op.getMejoraSalud()).replace(".", ","));
        txtSuerte.setText(String.format("%.2f", Float.parseFloat(txtSuerte.getText().replace(",", ".")) + op.getMejoraSuerte()).replace(".", ","));
        txtVelocidadLagrimas.setText(String.format("%.2f", Float.parseFloat(txtVelocidadLagrimas.getText().replace(",", ".")) + op.getMejoraVelocidadProyectil()).replace(".", ","));
    }

    // FUNCIONES DE CARGAR VENTANA

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

            PersonajeDAO personajeActual = new PersonajeDAO();
            int idPersonaje = personajeActual.seleccionarIDpersonaje();
            personajeActual.eliminarPersonaje(idPersonaje);
        } catch (IOException e) {
            Alertas.showError("Error al cargar ventana", "Ha sucedido un problema al cargar la ventana");
        }
    }

    // FUNCIONES DE CARGAR OBJETOS EN LA TABLA

    private void cargarPasivos() {
        ObjetoPasivoDAO objetoDAO = new ObjetoPasivoDAO();
        List<ObjetosPasivo> objetos = objetoDAO.getObjetosPasivos();

        tablaObjetos.getColumns().clear();

        TableColumn<Objeto, Object> colNombre = new TableColumn<>("Nombre");
        TableColumn<Objeto, Object> colEfecto = new TableColumn<>("Efecto");
        colEfecto.setMaxWidth(225);
        TableColumn<Objeto, Object> colDano = new TableColumn<>("Daño");
        TableColumn<Objeto, Object> colSalud = new TableColumn<>("Salud");
        TableColumn<Objeto, Object> colVelocidad = new TableColumn<>("Velocidad");
        TableColumn<Objeto, Object> colLagrimas = new TableColumn<>("Lágrimas");
        TableColumn<Objeto, Object> colVelocidadLagrimas = new TableColumn<>("V Lágrimas");
        TableColumn<Objeto, Object> colSuerte = new TableColumn<>("Suerte");

        colNombre.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNombre()));
        colEfecto.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getEfecto()));

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

        tablaObjetos.getColumns().addAll(colNombre, colDano, colSalud, colVelocidad, colLagrimas, colVelocidadLagrimas, colSuerte, colEfecto);

        tablaObjetos.getItems().setAll(objetos);
    }

    private void cargarActivos() {
        ObjetoActivoDAO activoDAO = new ObjetoActivoDAO();
        List<ObjetosActivo> activos = activoDAO.getObjetosActivos();

        tablaObjetos.getColumns().clear();

        TableColumn<Objeto, Object> colNombre = new TableColumn<>("Nombre");
        TableColumn<Objeto, Object> colEfecto = new TableColumn<>("Efecto");
        TableColumn<Objeto, Object> colRecarga = new TableColumn<>("Tiempo Recarga");

        colNombre.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNombre()));
        colEfecto.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getEfecto()));

        colRecarga.setCellValueFactory(cellData -> {
            if (cellData.getValue() instanceof ObjetosActivo) {
                return new SimpleObjectProperty<>(((ObjetosActivo) cellData.getValue()).getTiempoRecarga());
            }
            return null;
        });

        tablaObjetos.getColumns().addAll(colNombre, colEfecto, colRecarga);

        tablaObjetos.getItems().setAll(activos);
    }

    private void cargarConsumibles() {
        ConsumibleDAO consumibleDAO = new ConsumibleDAO();
        List<Consumible> consumibles = consumibleDAO.getConsumibles();

        tablaObjetos.getColumns().clear();

        TableColumn<Objeto, Object> colNombre = new TableColumn<>("Nombre");
        TableColumn<Objeto, Object> colEfecto = new TableColumn<>("Efecto");
        TableColumn<Objeto, Object> colDuracion = new TableColumn<>("Duración");

        colNombre.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNombre()));
        colEfecto.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getEfecto()));

        colDuracion.setCellValueFactory(cellData -> {
            if (cellData.getValue() instanceof Consumible) {
                return new SimpleObjectProperty<>(((Consumible) cellData.getValue()).getDuracionEfecto());
            }
            return null;
        });

        tablaObjetos.getColumns().addAll(colNombre, colEfecto, colDuracion);

        tablaObjetos.getItems().setAll(consumibles);
    }

    private void cargarTodosObjetos() {
        ObjetoDAO objetoDAO = new ObjetoDAO();
        List<Objeto> objetos = objetoDAO.getObjetos();

        tablaObjetos.getColumns().clear();

        TableColumn<Objeto, Object> colNombre = new TableColumn<>("Nombre");
        TableColumn<Objeto, Object> colEfecto = new TableColumn<>("Efecto");

        colNombre.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNombre()));
        colEfecto.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getEfecto()));

        tablaObjetos.getColumns().addAll(colNombre, colEfecto);

        tablaObjetos.getItems().setAll(objetos);
    }

    private void cargarObjetosInventario() {
        PersonajeDAO personajeDAO = new PersonajeDAO();
        int idPersonaje = personajeDAO.seleccionarIDpersonaje();
        List<Objeto> objetos = personajeDAO.showObjetosPersonaje(idPersonaje);

        tblInventario.getColumns().clear();
        TableColumn<Objeto, Object> colNombre = new TableColumn<>("Inventario");
        colNombre.setMinWidth(130);
        colNombre.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNombre()));
        tblInventario.getColumns().addAll(colNombre);

        tblInventario.getItems().setAll(objetos);
    }

    private void cargarActivoActual() {
        ObjetoActivoDAO activoDAO = new ObjetoActivoDAO();
        ObjetosActivo objetoActivo = activoDAO.ultimoObjetoActivo();
        txtItemActivo.setText(objetoActivo != null ? objetoActivo.getNombre() : "Ninguno");
    }

    private void cargarConsumibleActual() {
        ConsumibleDAO consumibleDAO = new ConsumibleDAO();
        Consumible consumible = consumibleDAO.ultimoConsumible();
        txtConsumible.setText(consumible != null ? consumible.getNombre() : "Ninguno");
    }

    private void cargarFiltradoPool() {
        HabitacionDAO habitacionDAO = new HabitacionDAO();
        List<Objeto> objetos = habitacionDAO.filtrarPool(mbtnHabitacion.getText());

        tablaObjetos.getColumns().clear();

        TableColumn<Objeto, Object> colNombre = new TableColumn<>("Nombre");
        TableColumn<Objeto, Object> colEfecto = new TableColumn<>("Efecto");

        colNombre.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNombre()));
        colEfecto.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getEfecto()));

        tablaObjetos.getColumns().addAll(colNombre, colEfecto);
        tablaObjetos.getItems().setAll(objetos);
    }

    // COMENTARIO EXAMEN: crear este método para cargar el código

    private void cargarCodigoPromocional() {
        PersonajeDAO personajeDAO = new PersonajeDAO();
        String codigo = personajeDAO.getCodigoPromocional();
        txtCodigoPromocion.setText(codigo);
    }

    // FUNCIONES DE MANEJO DE BOTONES

    private void activarBotonesInventario() {
        btnAnadirItem.setDisable(false);
        btnQuitarItem.setDisable(false);
    }

    private void desactivarBotonesInventario() {
        btnAnadirItem.setDisable(true);
        btnQuitarItem.setDisable(true);
    }

    private void activarBotonesConsumible() {
        btnInsertar.setDisable(false);
        btnModificar.setDisable(false);
        btnEliminar.setDisable(false);
    }

    private void desactivarBotonesConsumible() {
        btnInsertar.setDisable(true);
        btnModificar.setDisable(true);
        btnEliminar.setDisable(true);
    }
}