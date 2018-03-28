package com.vnu.library.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.vnu.library.data.BookInfo;
import com.vnu.library.data.BookInfoBuilder;

public class UpdateBookInfo2 extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4298630786845406109L;
	public static  final int MODE_VIEW_UPDATE = 1;
    public static final int MODE_ADD_NEW = 2;
    
    private int selectedBookId;
    private int mode = MODE_ADD_NEW;
    private IUpdateAndAddingBookListener updateAndAddingBookListener;
    
	private final JPanel panel = new JPanel();
	private JTextField textField_title;
	private JTextField textField_author;
	private JTextField textField_country;
	private JTextField textField_language;
	private JTextField textField_pages;
	private JTextField textField_quantity;
	private JTextField textField_publishdate;
	private JButton btn_confirm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DisplayBookListInfo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DisplayBookListInfo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DisplayBookListInfo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(DisplayBookListInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateBookInfo2 frame = new UpdateBookInfo2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UpdateBookInfo2() {
		super();
		setResizable(false);
		setMinimumSize(new Dimension(480, 360));
		initComponents();
	}
	
	public UpdateBookInfo2(BookInfo bookInfo, int mode, IUpdateAndAddingBookListener updateAndAddingBookListener) {
        this();
        this.mode = mode;
        this.updateAndAddingBookListener = updateAndAddingBookListener;
        if(bookInfo != null){
            selectedBookId = bookInfo.getId();
            fillFields(bookInfo);
        }
        
        if(mode == MODE_VIEW_UPDATE){
        	btn_confirm.setText("Cập nhật sách");
        }else{
        	btn_confirm.setText("Thêm sách");
        }
    }
	
    private void fillFields(BookInfo bookInfo){
    	textField_author.setText(bookInfo.getAuthor() != null ? bookInfo.getAuthor() : "");
    	textField_country.setText(bookInfo.getCountry() != null ? bookInfo.getCountry() : "");
    	textField_language.setText(bookInfo.getLanguage() != null ? bookInfo.getLanguage() : "");
    	textField_pages.setText(bookInfo.getPages() + "");
    	textField_title.setText(bookInfo.getTitle() != null ? bookInfo.getTitle() : "");
    	textField_publishdate.setText((bookInfo.getPublishDate() != null ? bookInfo.getPublishDate() : "") + "");
    	textField_quantity.setText(bookInfo.getQuantityInStock() + "");
    }
    
	private void initComponents() {
		setTitle("Hệ thống quản lý thư viện");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblThngTinSch = new JLabel("Thông tin sách");
		lblThngTinSch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblThngTinSch.setPreferredSize(new Dimension(70, 50));
		lblThngTinSch.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblThngTinSch, BorderLayout.NORTH);
		panel.setPreferredSize(new Dimension(5, 5));
		panel.setMinimumSize(new Dimension(1, 1));
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 75, 22, 294, 23, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 5.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel jLabel_title = new JLabel("Title");
		jLabel_title.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_jLabel_title = new GridBagConstraints();
		gbc_jLabel_title.fill = GridBagConstraints.HORIZONTAL;
		gbc_jLabel_title.insets = new Insets(0, 0, 5, 5);
		gbc_jLabel_title.gridx = 1;
		gbc_jLabel_title.gridy = 1;
		panel.add(jLabel_title, gbc_jLabel_title);
		
		textField_title = new JTextField();
		GridBagConstraints gbc_textField_title = new GridBagConstraints();
		gbc_textField_title.insets = new Insets(0, 0, 5, 5);
		gbc_textField_title.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_title.gridx = 3;
		gbc_textField_title.gridy = 1;
		panel.add(textField_title, gbc_textField_title);
		textField_title.setColumns(10);
		
		JLabel jLabel_author = new JLabel("Author");
		GridBagConstraints gbc_jLabel_author = new GridBagConstraints();
		gbc_jLabel_author.fill = GridBagConstraints.HORIZONTAL;
		gbc_jLabel_author.insets = new Insets(0, 0, 5, 5);
		gbc_jLabel_author.gridx = 1;
		gbc_jLabel_author.gridy = 2;
		panel.add(jLabel_author, gbc_jLabel_author);
		
		textField_author = new JTextField();
		GridBagConstraints gbc_textField_author = new GridBagConstraints();
		gbc_textField_author.insets = new Insets(0, 0, 5, 5);
		gbc_textField_author.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_author.gridx = 3;
		gbc_textField_author.gridy = 2;
		panel.add(textField_author, gbc_textField_author);
		textField_author.setColumns(10);
		
		JLabel jLabel_country = new JLabel("Country");
		GridBagConstraints gbc_jLabel_country = new GridBagConstraints();
		gbc_jLabel_country.fill = GridBagConstraints.HORIZONTAL;
		gbc_jLabel_country.insets = new Insets(0, 0, 5, 5);
		gbc_jLabel_country.gridx = 1;
		gbc_jLabel_country.gridy = 3;
		panel.add(jLabel_country, gbc_jLabel_country);
		
		textField_country = new JTextField();
		GridBagConstraints gbc_textField_country = new GridBagConstraints();
		gbc_textField_country.insets = new Insets(0, 0, 5, 5);
		gbc_textField_country.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_country.gridx = 3;
		gbc_textField_country.gridy = 3;
		panel.add(textField_country, gbc_textField_country);
		textField_country.setColumns(10);
		
		JLabel jLabel_language = new JLabel("Language");
		GridBagConstraints gbc_jLabel_language = new GridBagConstraints();
		gbc_jLabel_language.fill = GridBagConstraints.HORIZONTAL;
		gbc_jLabel_language.insets = new Insets(0, 0, 5, 5);
		gbc_jLabel_language.gridx = 1;
		gbc_jLabel_language.gridy = 4;
		panel.add(jLabel_language, gbc_jLabel_language);
		
		textField_language = new JTextField();
		GridBagConstraints gbc_textField_language = new GridBagConstraints();
		gbc_textField_language.insets = new Insets(0, 0, 5, 5);
		gbc_textField_language.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_language.gridx = 3;
		gbc_textField_language.gridy = 4;
		panel.add(textField_language, gbc_textField_language);
		textField_language.setColumns(10);
		
		JLabel jLabel_pages = new JLabel("Pages");
		GridBagConstraints gbc_jLabel_pages = new GridBagConstraints();
		gbc_jLabel_pages.fill = GridBagConstraints.HORIZONTAL;
		gbc_jLabel_pages.insets = new Insets(0, 0, 5, 5);
		gbc_jLabel_pages.gridx = 1;
		gbc_jLabel_pages.gridy = 5;
		panel.add(jLabel_pages, gbc_jLabel_pages);
		
		textField_pages = new JTextField();
		GridBagConstraints gbc_textField_pages = new GridBagConstraints();
		gbc_textField_pages.insets = new Insets(0, 0, 5, 5);
		gbc_textField_pages.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_pages.gridx = 3;
		gbc_textField_pages.gridy = 5;
		panel.add(textField_pages, gbc_textField_pages);
		textField_pages.setColumns(10);
		
		JLabel jLabel_quantity = new JLabel("Quantity");
		GridBagConstraints gbc_jLabel_quantity = new GridBagConstraints();
		gbc_jLabel_quantity.fill = GridBagConstraints.HORIZONTAL;
		gbc_jLabel_quantity.insets = new Insets(0, 0, 5, 5);
		gbc_jLabel_quantity.gridx = 1;
		gbc_jLabel_quantity.gridy = 6;
		panel.add(jLabel_quantity, gbc_jLabel_quantity);
		
		textField_quantity = new JTextField();
		GridBagConstraints gbc_textField_quantity = new GridBagConstraints();
		gbc_textField_quantity.insets = new Insets(0, 0, 5, 5);
		gbc_textField_quantity.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_quantity.gridx = 3;
		gbc_textField_quantity.gridy = 6;
		panel.add(textField_quantity, gbc_textField_quantity);
		textField_quantity.setColumns(10);
		
		JLabel jLabel_publishdate = new JLabel("Publish date");
		GridBagConstraints gbc_jLabel_publishdate = new GridBagConstraints();
		gbc_jLabel_publishdate.fill = GridBagConstraints.HORIZONTAL;
		gbc_jLabel_publishdate.insets = new Insets(0, 0, 5, 5);
		gbc_jLabel_publishdate.gridx = 1;
		gbc_jLabel_publishdate.gridy = 7;
		panel.add(jLabel_publishdate, gbc_jLabel_publishdate);
		
		textField_publishdate = new JTextField();
		GridBagConstraints gbc_textField_publishdate = new GridBagConstraints();
		gbc_textField_publishdate.insets = new Insets(0, 0, 5, 5);
		gbc_textField_publishdate.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_publishdate.gridx = 3;
		gbc_textField_publishdate.gridy = 7;
		panel.add(textField_publishdate, gbc_textField_publishdate);
		textField_publishdate.setColumns(10);
		
		btn_confirm = new JButton("Cập nhật");
		btn_confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
		        switch(mode){
		            case MODE_VIEW_UPDATE:
		                if(updateAndAddingBookListener != null){
		                	BookInfoBuilder builder = new BookInfoBuilder();
		                	builder.setId(selectedBookId);
		                	
		                	if(isValid(textField_title.getText(), String.class)){
		                		builder.setTitle(textField_title.getText());
		                	}else{
		                		System.out.println("Title is invalid");
		                		return;
		                	}
		                	
							if(isValid(textField_author.getText(), String.class)){
								builder.setAuthor(textField_author.getText());	                		
							}else{
								System.out.println("Author is invalid");
		                		return;
		                	}
							
							if(isValid(textField_country.getText(), String.class)){
								builder.setCountry(textField_country.getText());
							}else{
								System.out.println("Country is invalid");
		                		return;
		                	}
							
							if(isValid(textField_language.getText(), String.class)){
								builder.setLanguage(textField_language.getText());
							}else{
								System.out.println("Language is invalid");
		                		return;
		                	}
							
							if(isValid(textField_pages.getText(), Integer.class)){
								builder.setPages(Integer.valueOf(textField_pages.getText()));
							}else{
								System.out.println("Pages is invalid");
		                		return;
		                	}
							
							if(isValid(textField_quantity.getText(), Integer.class)){
								builder.setQuantityInStock(Integer.valueOf(textField_quantity.getText()));
							}else{
								System.out.println("Quantity is invalid");
		                		return;
		                	}

							if(isValid(textField_publishdate.getText(), String.class)){
								builder.setPublishDate(textField_publishdate.getText());						
							}else{
								System.out.println("PublishDate is invalid");
		                		return;
		                	}
							
		                    updateAndAddingBookListener.onUpdate(builder.createBookInfo());
		                }
		                
		                break;
		            
		            case MODE_ADD_NEW:
		                 if(updateAndAddingBookListener != null){
		                     BookInfoBuilder builder = new BookInfoBuilder();
		                     builder.setAuthor(textField_author.getText())
		                             .setCountry(textField_country.getText())
		                             .setLanguage(textField_language.getText())
		                             .setPages(Integer.valueOf(textField_pages.getText()))
		                             .setTitle(textField_title.getText())
		                             .setPublishDate(textField_publishdate.getText())
		                             .setQuantityInStock(Integer.valueOf(textField_quantity.getText()));
		                    updateAndAddingBookListener.onAddNew(builder.createBookInfo());
		                }
		                break;
		        }
			}
		});
		
		GridBagConstraints gbc_btn_confirm = new GridBagConstraints();
		gbc_btn_confirm.anchor = GridBagConstraints.EAST;
		gbc_btn_confirm.insets = new Insets(0, 0, 0, 5);
		gbc_btn_confirm.gridx = 3;
		gbc_btn_confirm.gridy = 8;
		panel.add(btn_confirm, gbc_btn_confirm);
	}
	
	private boolean isValid(String text, Class<?> type){
		if(type.equals(String.class)){
			return text != null && !text.isEmpty();
		}else if(type.equals(Integer.class)){
			return text != null && !text.isEmpty() && text.chars().allMatch( Character::isDigit );
		}
		
		return false;
	}
}
