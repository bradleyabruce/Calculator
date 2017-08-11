package Test;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorTestController implements Initializable{

	@FXML
    private Button btn7;

    @FXML
    private Button btn8;

    @FXML
    private Button btn9;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Button btn6;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private TextField tfAnswer;

    @FXML
    private Button btn0;

    @FXML
    private Button btnDecimal;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnSub;

    @FXML
    private Button btnMult;

    @FXML
    private Button btnDiv;

    @FXML
    private Button btnSolve;
    
    String num1;
    String num2;
    String equation;
	
    int toAdd = 0;
    int toSub = 0;
    int toMult = 0;
    int toDivide = 0;
    double Number1;
    double Number2;
    boolean isOver = false;
    int DecimalNumber = 0;
    boolean InUse = false;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		btnSolve.setOnAction(e->Solve());
		btnClear.setOnAction(e->Clear());
		
		btn1.setOnAction(e->EnterNumber1());
		btn2.setOnAction(e->EnterNumber2());
		btn3.setOnAction(e->EnterNumber3());
		btn4.setOnAction(e->EnterNumber4());
		btn5.setOnAction(e->EnterNumber5());
		btn6.setOnAction(e->EnterNumber6());
		btn7.setOnAction(e->EnterNumber7());
		btn8.setOnAction(e->EnterNumber8());
		btn9.setOnAction(e->EnterNumber9());
		btn0.setOnAction(e->EnterNumber0());
		btnDecimal.setOnAction(e->Decimal());
		
		btnAdd.setOnAction(e->Add());
		btnSub.setOnAction(e->Subtract());
		btnMult.setOnAction(e->Multiply());
		btnDiv.setOnAction(e->Divide());
		
	}//end Initialize
	
	private void Clear() {
		tfAnswer.clear();
		DecimalNumber = 0;
		num1 = null;
		num2 = null;
		toAdd = 0;
		toSub = 0;
		toMult = 0;
		toDivide =0;
		equation = null;
		InUse = false;
	}//end Clear()

	private void Solve() {
		
		if (num1 == null) {
			return;
		}
		
		if (num2 == null || num2 == ".") {
			return;
		}
		
		if (toAdd > 0) {
			
			equation = tfAnswer.getText();
			int replace = (equation.indexOf("+"));
			tfAnswer.replaceText(0, replace + 2, "");
			num2 = tfAnswer.getText();
			tfAnswer.clear();
			
			
			Double Number1 = Double.parseDouble(num1);
			Double Number2 = Double.parseDouble(num2);
			
			Double Answer = Number1 + Number2;
			DecimalFormat df = new DecimalFormat("###.####");
			String format = df.format(Answer);
			tfAnswer.setText(format);
			isOver = true;
		
		}//end if for add
		
		if (toSub > 0 ) {
			
			equation = tfAnswer.getText();
			int replace = (equation.indexOf("-"));
			tfAnswer.replaceText(0, replace + 2, "");
			num2 = tfAnswer.getText();
			tfAnswer.clear();
			
			
			Double Number1 = Double.parseDouble(num1);
			Double Number2 = Double.parseDouble(num2);
			
			Double Answer = Number1 - Number2;
			DecimalFormat df = new DecimalFormat("###.####");
			String format = df.format(Answer);
			tfAnswer.setText(format);
			isOver = true;
		
		}//end if for subtraction
		
		if (toMult > 0 ) {
			
			equation = tfAnswer.getText();
			int replace = (equation.indexOf("x"));
			tfAnswer.replaceText(0, replace + 2, "");
			num2 = tfAnswer.getText();
			tfAnswer.clear();
			
			
			Double Number1 = Double.parseDouble(num1);
			Double Number2 = Double.parseDouble(num2);
			
			Double Answer = Number1 * Number2;
			DecimalFormat df = new DecimalFormat("###.####");
			String format = df.format(Answer);
			tfAnswer.setText(format);
			isOver = true;
		
		}//end if for mutiplying
		
		if (toDivide > 0) {
			
			equation = tfAnswer.getText();
			int replace = (equation.indexOf("/"));
			tfAnswer.replaceText(0, replace + 2, "");
			num2 = tfAnswer.getText();
			tfAnswer.clear();
			
			
			Double Number1 = Double.parseDouble(num1);
			Double Number2 = Double.parseDouble(num2);
			
			Double Answer = Number1 / Number2;
			DecimalFormat df = new DecimalFormat("###.####");
			String format = df.format(Answer);
			tfAnswer.setText(format);
			isOver = true;
		
		}//end if for dividing

		InUse = false;
		
	}//end Solve()
	
	
	private void Add() {
		
		if (InUse == true) {
			return;
		}
		
		else {
			
	
		num1 = tfAnswer.getText();
		toAdd ++;
		toSub = 0;
		toMult = 0;
		toDivide = 0;
		tfAnswer.setText(num1 + " + ");
		isOver = false;
		DecimalNumber = 0;
		InUse = true;
		
		}
	}
	
	private void Subtract() {
		
		if (InUse == true) {
			return;
		}
		
		else {
			
		num1 = tfAnswer.getText();
		toSub++;
		toAdd = 0;
		toMult = 0;
		toDivide = 0;
		tfAnswer.setText(num1 + " - ");
		isOver = false;
		DecimalNumber = 0;
		InUse = true;
	}
	}
	
	private void Multiply() {
		
		if (InUse == true) {
			return;
		}
		else {
			
		num1 = tfAnswer.getText();
		toMult ++;
		toAdd = 0;
		toSub = 0;
		toDivide = 0;
		tfAnswer.setText(num1 + " x ");
		isOver = false;
		DecimalNumber = 0;
		InUse = true;
		}
	}
	private void Divide() {
		
		if (InUse == true) {
			return;
		}
		
		else {
		num1 = tfAnswer.getText();
		toDivide ++;
		toAdd = 0;
		toSub =0;
		toMult = 0;
		tfAnswer.setText(num1 + " / ");
		isOver = false;
		DecimalNumber = 0;
		InUse = true;
			}
	}//end Divide
	
	//if the decimal key is pressed before anything else add as "0."
	
	private void Decimal() {
		
		DecimalNumber ++;
		
		if (DecimalNumber > 1) {
			return;
		}
		
		else { 
			
		String CurrentText = tfAnswer.getText();
		tfAnswer.setText(CurrentText + ".");
	
		}
	
	}//end decimal
	
	
	private void EnterNumber1() {
		
		if (isOver == true) {
			tfAnswer.clear();
			num1 = null;
			num2 = null;
			equation = null;
		}
		isOver = false;
		
		String CurrentText = tfAnswer.getText();
		tfAnswer.setText(CurrentText + "1");
	}//end EnterNumber2
	
	private void EnterNumber2() {
		
		if (isOver == true) {
			tfAnswer.clear();
			num1 = null;
			num2 = null;
			int toAdd = 0;
			int toSub = 0;
			int toMult = 0;
			int toDivide = 0;
			double Number1 = 0;
			double Number2 = 0;
			equation = null;
		}
		isOver = false;
		
		String CurrentText = tfAnswer.getText();
		tfAnswer.setText(CurrentText + "2");
	}//end EnterNumber2
	
	private void EnterNumber3() {
		
		if (isOver == true) {
			tfAnswer.clear();
			num1 = null;
			num2 = null;
			int toAdd = 0;
			int toSub = 0;
			int toMult = 0;
			int toDivide = 0;
			double Number1 = 0;
			double Number2 = 0;
			equation = null;
		}
		isOver = false;
		
		
		String CurrentText = tfAnswer.getText();
		tfAnswer.setText(CurrentText + "3");
	}//end EnterNumber2
	
	private void EnterNumber4() {
		
		if (isOver == true) {
			tfAnswer.clear();
			num1 = null;
			num2 = null;
			int toAdd = 0;
			int toSub = 0;
			int toMult = 0;
			int toDivide = 0;
			double Number1 = 0;
			double Number2 = 0;
			equation = null;
		}
		isOver = false;
		
		String CurrentText = tfAnswer.getText();
		tfAnswer.setText(CurrentText + "4");
	}//end EnterNumber2
	
	private void EnterNumber5() {
		
		if (isOver == true) {
			tfAnswer.clear();
			num1 = null;
			num2 = null;
			int toAdd = 0;
			int toSub = 0;
			int toMult = 0;
			int toDivide = 0;
			double Number1 = 0;
			double Number2 = 0;
			equation = null;
		}
		isOver = false;
		
		String CurrentText = tfAnswer.getText();
		tfAnswer.setText(CurrentText + "5");
	}//end EnterNumber2
	
	private void EnterNumber6() {
		
		if (isOver == true) {
			tfAnswer.clear();
			num1 = null;
			num2 = null;
			int toAdd = 0;
			int toSub = 0;
			int toMult = 0;
			int toDivide = 0;
			double Number1 = 0;
			double Number2 = 0;
			equation = null;
		}
		isOver = false;
		
		String CurrentText = tfAnswer.getText();
		tfAnswer.setText(CurrentText + "6");
	}//end EnterNumber2
	
	private void EnterNumber7() {
		
		if (isOver == true) {
			tfAnswer.clear();
			num1 = null;
			num2 = null;
			int toAdd = 0;
			int toSub = 0;
			int toMult = 0;
			int toDivide = 0;
			double Number1 = 0;
			double Number2 = 0;
			equation = null;
		}
		isOver = false;
		
		String CurrentText = tfAnswer.getText();
		tfAnswer.setText(CurrentText + "7");
	}//end EnterNumber2
	
	private void EnterNumber8() {
		
		if (isOver == true) {
			tfAnswer.clear();
			num1 = null;
			num2 = null;
			int toAdd = 0;
			int toSub = 0;
			int toMult = 0;
			int toDivide = 0;
			double Number1 = 0;
			double Number2 = 0;
			equation = null;
		}
		isOver = false;
		
		String CurrentText = tfAnswer.getText();
		tfAnswer.setText(CurrentText + "8");
	}//end EnterNumber2
	
	private void EnterNumber9() {
		
		if (isOver == true) {
			tfAnswer.clear();
			num1 = null;
			num2 = null;
			int toAdd = 0;
			int toSub = 0;
			int toMult = 0;
			int toDivide = 0;
			double Number1 = 0;
			double Number2 = 0;
			equation = null;
		}
		isOver = false;
		
		String CurrentText = tfAnswer.getText();
		tfAnswer.setText(CurrentText + "9");
	}//end EnterNumber2
	
	private void EnterNumber0() {
		
		if (isOver == true) {
			tfAnswer.clear();
			num1 = null;
			num2 = null;
			int toAdd = 0;
			int toSub = 0;
			int toMult = 0;
			int toDivide = 0;
			double Number1 = 0;
			double Number2 = 0;
			equation = null;
		}
		isOver = false;
		
		String CurrentText = tfAnswer.getText();
		tfAnswer.setText(CurrentText + "0");
	}//end EnterNumber2
	
	
	
	
	
	
}//end class
