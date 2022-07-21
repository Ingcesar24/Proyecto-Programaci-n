package application;

import java.util.List;
import com.Message.chat.*;
import com.List.chat.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.input.MouseEvent;


public class Main extends Application {
	VBox ladoderecho = new VBox();
	ListaChat names = new ListaChat();
	public String user1 = "carlos";
	public String userFrom1 = "cesar";
	
	Label lbcontent;
	Label lbfecha;
	Label lbpara;
	ListaChat listachat  = new ListaChat();
	
	String userinv;
	@Override
	public void start(Stage escenario) throws Exception {
		
		VBox VbcontentIzq = new VBox(15);
		TextField txtusuario = new TextField();
		PasswordField clavePassWField = new PasswordField();
		Label ValidarAccesoLbl = new Label();
		Button bntlogin = new Button();
		bntlogin.setText("Iniciar Sesion");
		bntlogin.setOnAction(new EventHandler<ActionEvent>() {
			
			
			

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if(txtusuario.getText().equals("cesar") && clavePassWField.getText().equals("12345")) {
					escenario.close();
					
					ValidarAccesoLbl.setText("acceso permitido");
					ValidarAccesoLbl.setTextFill(Color.WHITE);
			      
					List<Message> result = names.getUser();
					//List<Message1> result1 = names.getUser();		
						
					VBox vbox = new VBox();
					//VBox vbox1 = new VBox();
					
					TextField buscar = new TextField();
					buscar.setText("Buscar nuevo chat...");
					//FilteredList<ListaChat> filteredData = new FilteredList<>(createPersonList(), p -> true);
					//tableView.setItems(filteredData);
					
					
					
					
			      	
					
					vbox.getChildren().add(0 ,buscar);
					
				
					
					for(Message us: result) {
						Image fotochats = new Image("https://cdn-icons-png.flaticon.com/512/1177/1177568.png");
						ImageView imagenx1 = new ImageView(fotochats);
						imagenx1.setFitHeight(50);
						imagenx1.setFitWidth(50);
						//Label boton1 = new Label("FOTO");
						lbpara = new Label(us.getTo());
						lbfecha = new Label(us.getDate());
						lbcontent = new Label(us.getContent());
						
						//boton1.setFont(Font.font("Comic Sans Ms", FontWeight.BLACK, 10));
						lbpara.setFont(Font.font("Comic Sans Ms", FontWeight.BLACK, 15));
						lbcontent.setFont(Font.font("Comic Sans Ms", FontWeight.BLACK, 10));
						lbfecha.setFont(Font.font("Comic Sans Ms", FontWeight.BLACK, 10));
							
						GridPane gripaneChatactivos = new GridPane();
						gripaneChatactivos.add(lbpara, 0, 0);
						gripaneChatactivos.add(lbcontent, 0, 1);
						gripaneChatactivos.add(lbfecha, 1, 0);

						gripaneChatactivos.setVgap(10);
						gripaneChatactivos.setHgap(10);
						
						
					   
						
						HBox hboxChatActivos = new HBox(15,imagenx1,gripaneChatactivos);
						hboxChatActivos.setPadding(new Insets(10, 0, 0, 10));
					  
								
						vbox.getChildren().addAll(hboxChatActivos);
						
						
						
						
						gripaneChatactivos.setId(us.getIduserfrom()+"");
						
						gripaneChatactivos.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){

							@Override
							public void handle(MouseEvent event) {
								ladoderecho.getChildren().clear();
								GridPane result =(GridPane) event.getSource();
								
								//System.out.println(result.getId());
								
								ScrollPane contconv = new  ScrollPane();
								contconv.setVbarPolicy(ScrollBarPolicy.ALWAYS);
								VBox conversacion = new VBox();
								conversacion.setSpacing(10);
								conversacion.setPrefHeight(600);
								contconv.setContent(conversacion);
								HBox escribirYenviar = new HBox();
								
								List<Message> result1 = names.getUser();
								for(Message user : result1) {
									String usercomp = new String(user.getIduserfrom()+"");
									
									if(usercomp.equals(result.getId())) {
										HBox encabezado = new HBox();
										Label usuariochat = new Label(user.getTo());
										Label horachat = new Label(user.getDate());
										Image fotochats = new Image("https://cdn-icons-png.flaticon.com/512/1177/1177568.png");
										ImageView imagenx1 = new ImageView(fotochats);
										imagenx1.setFitHeight(50);
										imagenx1.setFitWidth(50);
										VBox encab = new VBox();
										encab.setSpacing(5);
										encab.getChildren().addAll(usuariochat, horachat);
										encabezado.setSpacing(20);
										ladoderecho.getChildren().add(0,encabezado);
										encabezado.getChildren().addAll(imagenx1, encab);
										
										List<Message> conversacionComplet = names.getMessage(user.getTo(), "cesar"); 
										for(Message mensj : conversacionComplet) {
											if (mensj.getFrom().equals(user.getTo())) {
												userinv = user.getTo();
												Label mensajeEnv = new Label(mensj.getContent());
												HBox mensaje = new HBox();
												//mensajeEnv.setTextAlignment(TextAlignment.JUSTIFY);
												mensajeEnv.setWrapText(true);		
												mensajeEnv.setMaxWidth(350);
												mensajeEnv.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 15));
												mensajeEnv.setStyle("-fx-background-color: GREY ; -fx-background-radius: 8px;");
												mensajeEnv.setPadding(new Insets(6));
														
												mensaje.getChildren().addAll(mensajeEnv);
												mensaje.setPrefWidth(605);
												mensaje.setAlignment(Pos.TOP_LEFT);
												conversacion.getChildren().addAll(mensaje);
												
												
											}else {
												
												Label mensajeEnv = new Label(mensj.getContent());
												HBox mensaje = new HBox();
												//mensajeEnv.setTextAlignment(TextAlignment.JUSTIFY);
												mensajeEnv.setWrapText(true);		
												mensajeEnv.setMaxWidth(350);
												mensajeEnv.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 15));
												mensajeEnv.setStyle("-fx-background-color: CHARTREUSE; -fx-background-radius: 8px;");
												mensajeEnv.setPadding(new Insets(6));
														
												mensaje.getChildren().addAll(mensajeEnv);
												mensaje.setPrefWidth(605);
												mensaje.setAlignment(Pos.TOP_RIGHT);
												conversacion.getChildren().addAll(mensaje);
												
											}
										}	
									}
								}
								TextField EscribirMsg = new TextField();
								EscribirMsg.setPromptText("Escriba su Mensaje...");
								EscribirMsg.setPrefSize(500,50);
								Button enviar = new Button("Enviar");
								enviar.setFont(Font.font("Comic Sans MS",FontWeight.LIGHT,15));
								
								enviar.setStyle("-fx-background-color: BISQUE");
								enviar.setMaxWidth(150);
								enviar.setMinHeight(30);
								enviar.setOnAction(new EventHandler<ActionEvent>() {

									@Override
									public void handle(ActionEvent arg0) {
										
										Label mensajeEnv = new Label(EscribirMsg.getText());
										HBox mensaje = new HBox();
										//mensajeEnv.setTextAlignment(TextAlignment.JUSTIFY);
										mensajeEnv.setWrapText(true);		
										mensajeEnv.setMaxWidth(350);
										mensajeEnv.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 15));
										mensajeEnv.setStyle("-fx-background-color: CHARTREUSE; -fx-background-radius: 8px;");
										mensajeEnv.setPadding(new Insets(6));
												
										mensaje.getChildren().addAll(mensajeEnv);
										mensaje.setPrefWidth(605);
										mensaje.setAlignment(Pos.TOP_RIGHT);
										conversacion.getChildren().addAll(mensaje);
										
										GridPane result =(GridPane) event.getSource();
										int posci = new Integer(result.getId());
										vbox.getChildren().remove(posci);
										lbpara.setText(userinv);
										lbfecha.setText("10:15 p.m");
										lbcontent.setText(EscribirMsg.getText());
										GridPane gripaneChatactivos = new GridPane();
										gripaneChatactivos.add(lbpara, 0, 0);
										gripaneChatactivos.add(lbcontent, 0, 1);
										gripaneChatactivos.add(lbfecha, 1, 0);

										gripaneChatactivos.setVgap(10);
										gripaneChatactivos.setHgap(10);
										

										HBox hboxChatActivos = new HBox(15,imagenx1,gripaneChatactivos);
										hboxChatActivos.setPadding(new Insets(10, 0, 0, 10));
										
										
										
										vbox.getChildren().add(posci, hboxChatActivos);
										
										
										EscribirMsg.clear();
										
										gripaneChatactivos.setId(posci+"");
										
									}
									
								});
								
								escribirYenviar.getChildren().addAll(EscribirMsg,enviar);
								ladoderecho.getChildren().addAll(contconv,escribirYenviar);
								
								}
				
							});
					}
								

						ScrollPane scrollcontIzq = new ScrollPane();
						scrollcontIzq.setContent(vbox);
						scrollcontIzq.setFitToWidth(true);
						scrollcontIzq.setPrefWidth(300);
						scrollcontIzq.setHbarPolicy(ScrollBarPolicy.NEVER);
						scrollcontIzq.setVbarPolicy(ScrollBarPolicy.ALWAYS);
						scrollcontIzq.setPannable(true);
						
					
						
						
						AnchorPane PrinAnchorPane = new AnchorPane();
				        
				        AnchorPane.setTopAnchor(scrollcontIzq, 0.0);
				        AnchorPane.setLeftAnchor(scrollcontIzq,0.0);
				        AnchorPane.setBottomAnchor(scrollcontIzq, 0.0);
				        //AnchorPane.setRightAnchor(vbox,500.0);
				        
				        AnchorPane.setTopAnchor(ladoderecho, 0.0);
				        AnchorPane.setLeftAnchor(ladoderecho,300.0);
				        AnchorPane.setBottomAnchor(ladoderecho, 0.0);
				        AnchorPane.setRightAnchor(ladoderecho, 0.0);
				        
						
				        PrinAnchorPane.getChildren().addAll(scrollcontIzq, ladoderecho);
				        PrinAnchorPane.setStyle("-fx-background-color: CORNSILK");
				        Scene scene = new Scene(PrinAnchorPane, 1000, 500);
				        
				        Stage Stage = new Stage();
				        Stage.getIcons().add(new Image("https://cdn-icons-png.flaticon.com/128/1653/1653630.png"));
						Stage.setScene(scene);
						Stage.setTitle("WHATSAPP WEB");
						Stage.show();
						
						txtusuario.clear();
						clavePassWField.clear();
			         	
					
				}
				
				
				
				else {
					ValidarAccesoLbl.setText("acceso no permitido");
					ValidarAccesoLbl.setFont(Font.font(15));
					ValidarAccesoLbl.setTextFill(Color.WHITE);
					txtusuario.clear();
					clavePassWField.clear();
				}
			}
		});

      
		Label loguinLbl = new Label("------SING IN------");
		loguinLbl.setTextFill(Color.BLACK);
		loguinLbl.setFont(Font.font("Comic Sans MS",  FontWeight.BLACK, 20 ));
		
		//Label titulo = new Label("Mensajer�a");
		
		txtusuario.setFont(Font.font("Iskoola Pota", FontWeight.BLACK, 14));
		//user.setFocusTraversable(false);
		txtusuario.setMaxWidth(180);
		txtusuario.setMinHeight(30);
		
		clavePassWField.setFont(Font.font("Iskoola Pota", FontWeight.BLACK, 14));
		//clave.setFocusTraversable(false);
		clavePassWField.setMaxWidth(180);
		
		bntlogin.setFont(Font.font("tahoma", FontWeight.NORMAL, 14));
		bntlogin.setStyle("-fx-background-color: black");
		bntlogin.setTextFill(Color.WHITE);
		bntlogin.setMinHeight(30);
		bntlogin.setAlignment(Pos.CENTER);
		
		//titulo.setFont(Font.font("Bauhaus 93", FontWeight.EXTRA_BOLD, 18));
		//titulo.setStyle("-fx-text-fill: orange");
		
	
		Image simboloMensaje = new Image("https://cdn-icons-png.flaticon.com/512/1653/1653630.png");
		ImageView PonerSimboloMensaje = new ImageView(simboloMensaje);
		PonerSimboloMensaje.setFitHeight(70);
		PonerSimboloMensaje.setFitWidth(70);
		
		Image iconoUser = new Image("https://cdn-icons-png.flaticon.com/512/16/16363.png");
		ImageView imgPonerUser = new ImageView(iconoUser);
		imgPonerUser.setFitHeight(30);
		imgPonerUser.setFitWidth(30);
		

		HBox HbUsuarioText = new HBox();
		HbUsuarioText.getChildren().addAll(imgPonerUser,txtusuario);
		HbUsuarioText.setAlignment(Pos.CENTER);
	
		
		Image iconoCandado = new Image("https://cdn-icons-png.flaticon.com/512/102/102643.png");
		ImageView imgPonerCandado = new ImageView(iconoCandado);
		imgPonerCandado.setFitHeight(30);
		imgPonerCandado.setFitWidth(30);
	
		
		
		HBox ccons = new HBox();
		ccons.getChildren().addAll(imgPonerCandado, clavePassWField);
		ccons.setAlignment(Pos.CENTER);

		
		
		
		VbcontentIzq.getChildren().addAll(PonerSimboloMensaje,loguinLbl, HbUsuarioText,ccons,bntlogin,ValidarAccesoLbl);
		
		VbcontentIzq.setAlignment(Pos.CENTER);
		VbcontentIzq.setStyle("-fx-background-image:  url('https://i.pinimg.com/564x/c1/63/8e/c1638e641c355140042974ec7f810b59.jpg'); -fx-background-repeat: no-repeat; -fx-background-size: 500 500; -fx-background-position: center center;");
		
		Image fondo = new Image("https://fondosmil.com/fondo/456.jpg");
		ImageView imagen = new ImageView(fondo);
		
	
		
		
		Scene escena = new Scene(VbcontentIzq, 350, 400);
		escenario.getIcons().add(new Image("https://cdn-icons-png.flaticon.com/128/1653/1653630.png"));
		//escenario.getIcons().add(new Image(""));
		escenario.setTitle("WHATSAPP WEB");
		escenario.setScene(escena);
		escenario.show();
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}


