package swingGui;

import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainFrame extends JFrame {

	public JTextField address;
	public JLabel resAddress, resX, resY, jibunAddress, imageLabel;

	public MainFrame(String title){
		super(title); // 생성자 ) 윈도우 창 제목 설정

		setSize(700, 660); // frame size width, height

		JPanel pan = new JPanel();
		JLabel addressLbl = new JLabel("주소입력");
		address = new JTextField(50);
		JButton btn = new JButton("클릭");

		pan.add(addressLbl);
		pan.add(address);
		pan.add(btn);

		btn.addActionListener(e -> {
			try {
				new NaverMap(this);
			} catch (IOException ex) {
				System.err.println("입출력 예외 발생");
			} catch (ParseException ex) {
				System.err.println("파서 예외 발생");
			}
		});

		imageLabel = new JLabel("지도보기");

		JPanel pan1 = new JPanel();
		pan1.setLayout(new GridLayout(4,1));
		resAddress = new JLabel("도로명");
		jibunAddress = new JLabel("지번주소");
		resX = new JLabel("경도");
		resY = new JLabel("위도");

		pan1.add(resAddress);
		pan1.add(jibunAddress);
		pan1.add(resX);
		pan1.add(resY);

		setLayout(new BorderLayout());
		add(BorderLayout.NORTH, pan);
		add(BorderLayout.CENTER, imageLabel);
		add(BorderLayout.SOUTH, pan1);

		setVisible(true); // visible - 등록한 속성을 보이게 ( 윗줄에 있으면 등록한 속성들이 안보임 )
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // frame close = main end
	}
}
