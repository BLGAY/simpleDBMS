package Operation;

public class Help {
	public static void run() {
		ui.View.setOut("+--------------------------------------------------------------------+\n");
		
		ui.View.setOut("create����������ͼ���⡿ : CREATE TABLE <����>\n");
		ui.View.setOut("                ([<����><��������>[<��������Լ������>]��\n");
		ui.View.setOut("                 [������]��\n");
		ui.View.setOut("                 [��������Լ������]);\n");
		ui.View.setOut("                     CREATE DATABASE <����>;\n");
		ui.View.setOut("                     CREATE VIEW <��ͼ��> AS SLECT ���ԡ����� FROM <����>\n");
		ui.View.setOut("alter�����ӡ�ɾ�����޸��в����� : ALTER TABLE <����> \n");
		ui.View.setOut("                                [ADD <������><��������><��������Լ��>];\n");
		ui.View.setOut("                                [DROP <��������Լ����>];\n");
		ui.View.setOut("                                [MODIFY <����><��������>];\n");
		ui.View.setOut("use��ѡ��ʹ�õĿ⡿ : use <����>; \n");
		ui.View.setOut("show����ʾ���б�����ݡ� : show;\n");
		ui.View.setOut("history����ʾ��ʷ������ : history;\n");
		
		ui.View.setOut("+--------------------------------------------------------------------+\n");
		
	}
}
