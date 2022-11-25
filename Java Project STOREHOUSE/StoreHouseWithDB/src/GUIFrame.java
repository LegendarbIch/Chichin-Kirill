
import database_and_memory.Const;
import database_and_memory.DataBaseRepository;
import entities.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.*;
import java.util.List;

public class GUIFrame extends JFrame {
    private JPanel MainPanel;
    private JButton buyersButton;
    private JButton skladButton;
    private JButton providersButton;
    private JButton AddProductButton;
    private JButton GiveBuyerProductButton;
    private JButton AvalibleProdPositionsButton;
    private JButton GroupProdOnTypeButton;
    private JButton AddBuyerButton;
    private JButton InfoAboutBuyersButton;
    private JButton InfoAboutProvidersButton;
    private JEditorPane EditorPane;
    private JEditorPane EditorPane1;
    private JTextField textField2;
    private JTextField textField1;
    private JEditorPane EditorPane2;
    private JTextField textField3;
    private JEditorPane EditorPane3;
    private JTextField textField4;
    private JButton ADDBUTTON;
    private JPanel MENU;
    private JPanel SkladFunctions;
    private JPanel BuyersFunctions;
    private JPanel ProviderFuncions;
    private JPanel AddProductPanel;
    private JPanel AddBuyerPanel;
    private JPanel BuyersPanel;
    private JPanel ProvidersPanel;
    private JPanel InfoOnProviderPanel;
    private JEditorPane takebuyerEditorPane;
    private JPanel GiveProductToBuyerPanel;
    private JList<Object> list1;
    private JEditorPane editorPane1;
    private JList<Object> list2;
    private JEditorPane editorPane2;
    private JEditorPane takeprodEditorPane;
    private JScrollPane jskrollbuyers;
    private JScrollPane jskrollproducts;
    private JButton CreateOrderButton;
    private JEditorPane EditorPane4;
    private JTextField textField6;
    private JPanel AvailableProductPositionsPanel;
    private JScrollPane jskrollTable;
    private JTable avalidprodTable;
    private JEditorPane количествоEditorPane;
    private JTextField textField7;
    private JEditorPane replenishwarehouseEditorPane;
    private JEditorPane idEditorPane;
    private JTextField textField8;
    private JEditorPane ValueEditorPane1;
    private JTextField textField9;
    private JButton addButton;
    private JEditorPane idEditorPane1;
    private JEditorPane AvailableEditorPane;
    private JButton CheckButton;
    private JTextField textField10;
    private JList list3;
    private JList list4;
    private JEditorPane ProductTypeEditorPane;
    private JEditorPane productEditorPane;
    private JPanel GroupingProduct;
    private JEditorPane BuyerNameJpane;
    private JTextField textfield;
    private JButton buyersaddbuttom;
    private JEditorPane buyerjpane;
    private JEditorPane givedproductjapne;
    private JPanel ShowInfoBuyersPanel;
    private JList jlist11;
    private JList jlist12;
    private JTextField textField5;
    private JButton deletebutton;
    private JEditorPane deletbuyerEditorPanel;
    private JEditorPane deleteProductEditorPane;
    private JTextField textfield15;
    private JButton deleteproductbuttom;
    private JPanel GroupingProvidersPanel;
    private JList JList17;
    private JList JList18;
    private JTextArea операцииTextArea;
    private JPanel ProductsPanel;
    private Vector<String> columnnames;
    private List<Integer> BuyersIDs;
    private List<Integer> ProductIDs;

    private List<Integer> ProvidersIDs;
    private JPanel currentPanel;
    private JPanel currentFunctionPanel;

    private int currentBuyerID = 0;
    private int currentProductID = 0;

    private int currentProviderID = 0;

    private int currentAmount = 0;
    public DataBaseRepository dbrepository = new DataBaseRepository();


    public GUIFrame() {
        $$$setupUI$$$();
        currentPanel = SkladFunctions;
        currentFunctionPanel = AddProductPanel;
        setContentPane(MainPanel);
        setVisible(true);

        BuyersFunctions.setVisible(false);
        ProviderFuncions.setVisible(false);

        AddProductPanel.setVisible(false);
        GiveProductToBuyerPanel.setVisible(false);
        AvailableProductPositionsPanel.setVisible(false);
        GroupingProduct.setVisible(false);
        ShowInfoBuyersPanel.setVisible(false);
        InfoOnProviderPanel.setVisible(false);

        AddBuyerPanel.setVisible(false);
        InfoOnProviderPanel.setVisible(false);


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ADDBUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dbrepository.addProductToDB(textField1.getText(), Integer.parseInt(textField3.getText()), textField4.getText(), textField2.getText(), Integer.parseInt(textField6.getText()));
                    JOptionPane.showMessageDialog(new JFrame(), "Товар добавлен", "Dialog",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException | ClassNotFoundException | NumberFormatException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), "Заполните данные о товаре", "Dialog",
                            JOptionPane.ERROR_MESSAGE);
                    throw new RuntimeException(ex);
                }
            }
        });
        AddProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFunctionPanel.setVisible(false);
                AddProductPanel.setVisible(true);
                currentFunctionPanel = AddProductPanel;
                pack();
            }
        });

        buyersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPanel.setVisible(false);
                currentFunctionPanel.setVisible(false);
                BuyersFunctions.setVisible(true);
                currentPanel = BuyersFunctions;
            }
        });
        providersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPanel.setVisible(false);
                currentFunctionPanel.setVisible(false);
                ProviderFuncions.setVisible(true);
                currentPanel = ProviderFuncions;
            }
        });
        skladButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPanel.setVisible(false);
                currentFunctionPanel.setVisible(false);
                SkladFunctions.setVisible(true);
                currentPanel = SkladFunctions;
            }
        });
        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getClickCount() == 2) {
                    int b = BuyersIDs.get(list1.getSelectedIndex());
                    try {
                        currentBuyerID = b;
                        editorPane1.setText(dbrepository.getBuyersFromDBbyID(b));
                    } catch (SQLException | ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        GiveBuyerProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                currentFunctionPanel.setVisible(false);
                GiveProductToBuyerPanel.setVisible(true);
                currentFunctionPanel = GiveProductToBuyerPanel;
                DefaultListModel<Object> defaultListModel = new DefaultListModel<>();
                DefaultListModel<Object> defaultListModel2 = new DefaultListModel<>();
                BuyersIDs = new ArrayList<>();
                ProductIDs = new ArrayList<>();
                try {
                    dbrepository.FillBuyersFromDB();
                    for (Buyer buyer : dbrepository.getInMR().getBuyers()) {
                        defaultListModel.addElement(buyer.toString());
                        BuyersIDs.add(buyer.getBuyerId());
                    }
                    list1.setModel(defaultListModel);
                } catch (SQLException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } finally {
                    list1.revalidate();
                    dbrepository.getInMR().getBuyers().clear();
                }
                try {
                    dbrepository.FillProductsFromDB();
                    for (Product product : dbrepository.getInMR().getProducts()) {
                        defaultListModel2.addElement(product.toString());
                        ProductIDs.add(product.getProductArticle());
                    }
                    list2.setModel(defaultListModel2);
                } catch (SQLException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } finally {
                    list2.revalidate();
                    dbrepository.getInMR().getProducts().clear();
                }

            }
        });
        list2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getClickCount() == 2) {
                    int b = ProductIDs.get(list2.getSelectedIndex());
                    try {
                        currentProductID = b;
                        editorPane2.setText(dbrepository.getProductFromDBbyID(b));
                    } catch (SQLException | ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        CreateOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    try {
                        currentAmount = Integer.parseInt(textField7.getText());
                    } catch (NumberFormatException exx) {
                        JOptionPane.showMessageDialog(new JFrame(), "Введите количество", "Dialog",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    dbrepository.addOrderToDB(currentBuyerID, currentProductID, currentAmount);

                } catch (SQLException | ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), "Сначала необходимо выбрать покупателя и товар и его количество.", "Dialog",
                            JOptionPane.ERROR_MESSAGE);
                    throw new RuntimeException(ex);
                }
            }
        });
        AvalibleProdPositionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFunctionPanel.setVisible(false);
                AvailableProductPositionsPanel.setVisible(true);
                currentFunctionPanel = AvailableProductPositionsPanel;
                avalidprodTable = new JTable(dbrepository.getTableData(Const.PRODUCT_TABLE), columnnames);
                jskrollTable.setViewportView(avalidprodTable);
                pack();
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dbrepository.addFishedProductToDB(Integer.parseInt(textField8.getText()), Integer.parseInt(textField9.getText()));
                    avalidprodTable = new JTable(dbrepository.getTableData(Const.PRODUCT_TABLE), columnnames);
                    jskrollTable.setViewportView(avalidprodTable);
                } catch (SQLException | NumberFormatException E) {
                    JOptionPane.showMessageDialog(new JFrame(), "Поля id и количество пустые", "Dialog",
                            JOptionPane.ERROR_MESSAGE);
                    throw new RuntimeException(E);
                }
            }
        });
        CheckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dbrepository.FillProductsFromDB();
                    int id = 0;
                    try {
                        id = Integer.parseInt(textField10.getText());
                    } catch (NumberFormatException e1) {
                        JOptionPane.showMessageDialog(new JFrame(), "Введите id", "Dialog",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    if (dbrepository.getInMR().getProductByID(id) == null) {
                        JOptionPane.showMessageDialog(new JFrame(), "Такого id нету", "Dialog",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        if (dbrepository.getInMR().getProductByID(id).getAmount() > 0) {
                            JOptionPane.showMessageDialog(new JFrame(), "Товар " + dbrepository.getInMR().getProductByID(id).getProductName() + " есть в наличии", "Dialog",
                                    JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(new JFrame(), "Товара " + dbrepository.getInMR().getProductByID(id).getProductName() + " нет в наличии", "Dialog",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        GroupProdOnTypeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFunctionPanel.setVisible(false);
                GroupingProduct.setVisible(true);
                currentFunctionPanel = GroupingProduct;
                DefaultListModel<Object> defaultListModel = new DefaultListModel<>();
                try {
                    dbrepository.FillProductTypeFromDB();
                    for (ProductType productType : dbrepository.getInMR().getProductTypes()) {
                        defaultListModel.addElement(productType.getProductTypeName());
                    }
                    list3.setModel(defaultListModel);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } finally {
                    list3.revalidate();
                    dbrepository.getInMR().getProductTypes().clear();
                }

            }
        });
        list3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getClickCount() == 2) {
                    DefaultListModel<Object> defaultListModel1 = new DefaultListModel<>();
                    try {
                        String srt = (String) list3.getSelectedValue();
                        for (int i = 0; i < dbrepository.getGroupingProductOnType(srt).size(); i++) {
                            defaultListModel1.addElement(dbrepository.getGroupingProductOnType(srt).get(i));
                        }
                        list4.setModel(defaultListModel1);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } finally {
                        list4.revalidate();
                        dbrepository.getInMR().getProducts().clear();
                    }
                }
            }
        });
        AddBuyerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFunctionPanel.setVisible(false);
                AddBuyerPanel.setVisible(true);
                currentFunctionPanel = AddBuyerPanel;
                pack();
            }
        });
        buyersaddbuttom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dbrepository.addBuyerToDB(textfield.getText());
                    JOptionPane.showMessageDialog(new JFrame(), "Покупатель добавлен", "Dialog",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException | ClassNotFoundException | NumberFormatException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), "Введите данные покупателя", "Dialog",
                            JOptionPane.ERROR_MESSAGE);
                    throw new RuntimeException(ex);
                }
            }
        });
        InfoAboutBuyersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFunctionPanel.setVisible(false);
                ShowInfoBuyersPanel.setVisible(true);
                currentFunctionPanel = ShowInfoBuyersPanel;
                DefaultListModel<Object> defaultListModel = new DefaultListModel<>();
                try {
                    dbrepository.FillBuyersFromDB();
                    for (Buyer buyer : dbrepository.getInMR().getBuyers()) {
                        defaultListModel.addElement(buyer.toString());
                    }
                    jlist11.setModel(defaultListModel);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                } finally {
                    dbrepository.getInMR().getBuyers().clear();
                    jlist12.removeAll();
                }
                pack();
            }
        });
        jlist11.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getClickCount() == 2) {
                    DefaultListModel<Object> defaultListModel1 = new DefaultListModel<>();
                    BuyersIDs = new ArrayList<>();
                    try {
                        dbrepository.FillBuyersFromDB();
                        dbrepository.FillProductsFromDB();
                        dbrepository.FillOrdersFromDB();
                        for (Buyer buyer : dbrepository.getInMR().getBuyers()) {
                            BuyersIDs.add(buyer.getBuyerId());
                        }
                        int b = BuyersIDs.get(jlist11.getSelectedIndex());
                        currentBuyerID = b;
                        boolean bl = false;
                        for (Order order : dbrepository.getInMR().getOrders()) {
                            if (order.getBuyerID() == currentBuyerID) {
                                defaultListModel1.addElement(dbrepository.getProductFromDBbyID(order.getProductsID()));
                                bl = true;
                            }
                        }
                        if (bl == false) {
                            JOptionPane.showMessageDialog(new JFrame(), "У покупателя нет заказов", "Dialog",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                        jlist12.setModel(defaultListModel1);
                    } catch (SQLException | ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    } finally {
                        list4.revalidate();
                        dbrepository.getInMR().getProducts().clear();
                        dbrepository.getInMR().getOrders().clear();
                        dbrepository.getInMR().getBuyers().clear();
                    }
                    pack();
                }
            }
        });
        deletebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dbrepository.deleteOrderFromDB(Integer.parseInt(textField5.getText()), Const.ORDER_BUYER_ID);
                    dbrepository.deleteBuyerFromDB(Integer.parseInt(textField5.getText()));
                    JOptionPane.showMessageDialog(new JFrame(), "Покупатель удален", "Dialog",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException | NumberFormatException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), "Введите id покупателя", "Dialog",
                            JOptionPane.ERROR_MESSAGE);
                    throw new RuntimeException(ex);
                }
            }
        });
        deleteproductbuttom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dbrepository.deleteOrderFromDB(Integer.parseInt(textfield15.getText()), Const.ORDER_PRODUCT_ID);
                    dbrepository.deleteProductFromDB(Integer.parseInt(textfield15.getText()));
                    JOptionPane.showMessageDialog(new JFrame(), "Товар удален", "Dialog",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException | NumberFormatException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), "Введите id товара", "Dialog",
                            JOptionPane.ERROR_MESSAGE);
                    throw new RuntimeException(ex);
                }
            }
        });
        InfoAboutProvidersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFunctionPanel.setVisible(false);
                InfoOnProviderPanel.setVisible(true);
                currentFunctionPanel = InfoOnProviderPanel;
                DefaultListModel<Object> defaultListModel = new DefaultListModel<>();
                try {
                    dbrepository.FillProvidersFromDB();
                    for (Provider provider : dbrepository.getInMR().getProviders()) {
                        defaultListModel.addElement(provider.toString());
                    }
                    JList17.setModel(defaultListModel);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                } finally {
                    dbrepository.getInMR().getProviders().clear();
                    JList17.removeAll();
                }
                pack();
            }
        });
        JList17.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getClickCount() == 2) {
                    DefaultListModel<Object> defaultListModel1 = new DefaultListModel<>();
                    ProvidersIDs = new ArrayList<>();
                    try {
                        dbrepository.FillProvidersFromDB();
                        dbrepository.FillProductsFromDB();
                        dbrepository.FillOrdersFromDB();
                        for (Provider provider : dbrepository.getInMR().getProviders()) {
                            ProvidersIDs.add(provider.getProviderID());
                        }
                        int b = ProvidersIDs.get(JList17.getSelectedIndex());
                        currentProviderID = b;
                        boolean bl = false;
                        for (Product product : dbrepository.getInMR().getProducts()) {
                            if (Objects.equals(product.getProviderName(), dbrepository.getInMR().getProviderByID(currentProviderID).getProviderName())) {
                                defaultListModel1.addElement(product.toString());
                                bl = true;
                            }
                        }
                        if (!bl) {
                            JOptionPane.showMessageDialog(new JFrame(), "У поставщика нет поставляемых товаров", "Dialog",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                        JList18.setModel(defaultListModel1);
                    } catch (SQLException | ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    } finally {
                        list4.revalidate();
                        dbrepository.getInMR().getProducts().clear();
                        dbrepository.getInMR().getOrders().clear();
                        dbrepository.getInMR().getProviders().clear();
                    }
                    pack();
                }
            }
        });
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        MainPanel = new JPanel();
        MainPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 5, new Insets(0, 0, 0, 0), -1, -1));
        MainPanel.setDoubleBuffered(true);
        MainPanel.setInheritsPopupMenu(false);
        MainPanel.setOpaque(true);
        MainPanel.setBorder(BorderFactory.createTitledBorder(null, "Управление складом", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, this.$$$getFont$$$("Courier New", Font.BOLD, 18, MainPanel.getFont()), new Color(-16055034)));
        MENU = new JPanel();
        MENU.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        MENU.setEnabled(true);
        MENU.setVisible(true);
        MainPanel.add(MENU, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(527, 53), null, 0, false));
        providersButton = new JButton();
        providersButton.setText("Поставщики");
        MENU.add(providersButton, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(78, 49), null, 0, false));
        buyersButton = new JButton();
        buyersButton.setText("Покупатели");
        MENU.add(buyersButton, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(78, 49), null, 0, false));
        skladButton = new JButton();
        skladButton.setText("Склад");
        MENU.add(skladButton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(78, 49), null, 0, false));
        SkladFunctions = new JPanel();
        SkladFunctions.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 2, new Insets(0, 0, 0, 0), -1, -1));
        SkladFunctions.setEnabled(true);
        MainPanel.add(SkladFunctions, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(527, 209), null, 0, false));
        AddProductButton = new JButton();
        AddProductButton.setText("Добавить товар на склад");
        SkladFunctions.add(AddProductButton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        GiveBuyerProductButton = new JButton();
        GiveBuyerProductButton.setText("Отпустить товар покупателю");
        SkladFunctions.add(GiveBuyerProductButton, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        AvalibleProdPositionsButton = new JButton();
        AvalibleProdPositionsButton.setText("Доступные позиции товара");
        SkladFunctions.add(AvalibleProdPositionsButton, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        GroupProdOnTypeButton = new JButton();
        GroupProdOnTypeButton.setText("Группировка товаров по видам");
        SkladFunctions.add(GroupProdOnTypeButton, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        BuyersFunctions = new JPanel();
        BuyersFunctions.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        MainPanel.add(BuyersFunctions, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        AddBuyerButton = new JButton();
        AddBuyerButton.setText("Добавить покупателя");
        BuyersFunctions.add(AddBuyerButton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        InfoAboutBuyersButton = new JButton();
        InfoAboutBuyersButton.setText("Информация по покупателям");
        BuyersFunctions.add(InfoAboutBuyersButton, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ProviderFuncions = new JPanel();
        ProviderFuncions.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        MainPanel.add(ProviderFuncions, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        InfoAboutProvidersButton = new JButton();
        InfoAboutProvidersButton.setText("Информация по поставщикам");
        ProviderFuncions.add(InfoAboutProvidersButton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        MainPanel.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        AddProductPanel = new JPanel();
        AddProductPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(11, 1, new Insets(0, 0, 0, 0), -1, -1));
        AddProductPanel.setAutoscrolls(false);
        AddProductPanel.setEnabled(true);
        AddProductPanel.setVisible(true);
        MainPanel.add(AddProductPanel, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        EditorPane = new JEditorPane();
        EditorPane.setEditable(false);
        EditorPane.setText("Название товара:");
        AddProductPanel.add(EditorPane, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 50), null, 0, false));
        EditorPane1 = new JEditorPane();
        EditorPane1.setDoubleBuffered(false);
        EditorPane1.setDragEnabled(true);
        EditorPane1.setEditable(false);
        EditorPane1.setText("Поставщик:");
        AddProductPanel.add(EditorPane1, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        textField2 = new JTextField();
        AddProductPanel.add(textField2, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        textField1 = new JTextField();
        AddProductPanel.add(textField1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        EditorPane2 = new JEditorPane();
        EditorPane2.setEditable(false);
        EditorPane2.setText("Цена за единицу товара");
        AddProductPanel.add(EditorPane2, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        textField3 = new JTextField();
        AddProductPanel.add(textField3, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        EditorPane3 = new JEditorPane();
        EditorPane3.setEditable(false);
        EditorPane3.setText("Тип товара:");
        AddProductPanel.add(EditorPane3, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        textField4 = new JTextField();
        AddProductPanel.add(textField4, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        ADDBUTTON = new JButton();
        ADDBUTTON.setText("Добавить");
        ADDBUTTON.setToolTipText("Добавлено");
        AddProductPanel.add(ADDBUTTON, new com.intellij.uiDesigner.core.GridConstraints(10, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        EditorPane4 = new JEditorPane();
        EditorPane4.setEditable(false);
        EditorPane4.setText("Количество:");
        AddProductPanel.add(EditorPane4, new com.intellij.uiDesigner.core.GridConstraints(8, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        textField6 = new JTextField();
        AddProductPanel.add(textField6, new com.intellij.uiDesigner.core.GridConstraints(9, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        AddBuyerPanel = new JPanel();
        AddBuyerPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 3, new Insets(0, 0, 0, 0), -1, -1));
        AddBuyerPanel.setAutoscrolls(false);
        AddBuyerPanel.setEnabled(true);
        AddBuyerPanel.setVisible(true);
        MainPanel.add(AddBuyerPanel, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        AddBuyerPanel.setBorder(BorderFactory.createTitledBorder(null, "Добавить покупателя", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        AddBuyerPanel.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        textfield = new JTextField();
        panel1.add(textfield, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        buyersaddbuttom = new JButton();
        buyersaddbuttom.setText("Добавить");
        buyersaddbuttom.setToolTipText("Добавлено");
        panel1.add(buyersaddbuttom, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        AddBuyerPanel.add(panel2, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_SOUTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        BuyerNameJpane = new JEditorPane();
        BuyerNameJpane.setEditable(false);
        BuyerNameJpane.setText("Имя покупателя");
        panel2.add(BuyerNameJpane, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_SOUTH, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(150, 50), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        AddBuyerPanel.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        AddBuyerPanel.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        InfoOnProviderPanel = new JPanel();
        InfoOnProviderPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        MainPanel.add(InfoOnProviderPanel, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        GroupingProvidersPanel = new JPanel();
        GroupingProvidersPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        InfoOnProviderPanel.add(GroupingProvidersPanel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        GroupingProvidersPanel.setBorder(BorderFactory.createTitledBorder(null, "Информация по поставщикам", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        final JScrollPane scrollPane1 = new JScrollPane();
        GroupingProvidersPanel.add(scrollPane1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        JList17 = new JList();
        final DefaultListModel defaultListModel1 = new DefaultListModel();
        JList17.setModel(defaultListModel1);
        scrollPane1.setViewportView(JList17);
        final JScrollPane scrollPane2 = new JScrollPane();
        GroupingProvidersPanel.add(scrollPane2, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        JList18 = new JList();
        scrollPane2.setViewportView(JList18);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        GroupingProvidersPanel.add(panel3, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JEditorPane editorPane3 = new JEditorPane();
        editorPane3.setEditable(false);
        editorPane3.setText("Поставщик");
        panel3.add(editorPane3, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        GroupingProvidersPanel.add(panel4, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JEditorPane editorPane4 = new JEditorPane();
        editorPane4.setEditable(false);
        editorPane4.setText("Поставляемые товары");
        panel4.add(editorPane4, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        GiveProductToBuyerPanel = new JPanel();
        GiveProductToBuyerPanel.setLayout(new GridBagLayout());
        MainPanel.add(GiveProductToBuyerPanel, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        GiveProductToBuyerPanel.setBorder(BorderFactory.createTitledBorder(null, "Создание заказа", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        jskrollbuyers = new JScrollPane();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        GiveProductToBuyerPanel.add(jskrollbuyers, gbc);
        list1.setLayoutOrientation(0);
        jskrollbuyers.setViewportView(list1);
        jskrollproducts = new JScrollPane();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        GiveProductToBuyerPanel.add(jskrollproducts, gbc);
        jskrollproducts.setViewportView(list2);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        GiveProductToBuyerPanel.add(spacer4, gbc);
        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.VERTICAL;
        GiveProductToBuyerPanel.add(spacer5, gbc);
        takebuyerEditorPane = new JEditorPane();
        takebuyerEditorPane.setEditable(false);
        takebuyerEditorPane.setText("Выберите покупателя");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        GiveProductToBuyerPanel.add(takebuyerEditorPane, gbc);
        takeprodEditorPane = new JEditorPane();
        takeprodEditorPane.setEditable(false);
        takeprodEditorPane.setText("Выберите товар");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        GiveProductToBuyerPanel.add(takeprodEditorPane, gbc);
        editorPane2 = new JEditorPane();
        editorPane2.setBackground(new Color(-3226947));
        editorPane2.setEditable(false);
        editorPane2.setForeground(new Color(-16777216));
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        GiveProductToBuyerPanel.add(editorPane2, gbc);
        editorPane1 = new JEditorPane();
        editorPane1.setBackground(new Color(-5526609));
        editorPane1.setEditable(false);
        editorPane1.setForeground(new Color(-16777216));
        editorPane1.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        GiveProductToBuyerPanel.add(editorPane1, gbc);
        final JPanel spacer6 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        GiveProductToBuyerPanel.add(spacer6, gbc);
        количествоEditorPane = new JEditorPane();
        количествоEditorPane.setBackground(new Color(-3227504));
        количествоEditorPane.setEditable(false);
        количествоEditorPane.setForeground(new Color(-16777216));
        количествоEditorPane.setText("Количество");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        GiveProductToBuyerPanel.add(количествоEditorPane, gbc);
        textField7 = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        GiveProductToBuyerPanel.add(textField7, gbc);
        CreateOrderButton = new JButton();
        CreateOrderButton.setText("Выдать товар");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        GiveProductToBuyerPanel.add(CreateOrderButton, gbc);
        AvailableProductPositionsPanel = new JPanel();
        AvailableProductPositionsPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        MainPanel.add(AvailableProductPositionsPanel, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        jskrollTable = new JScrollPane();
        AvailableProductPositionsPanel.add(jskrollTable, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        jskrollTable.setViewportView(avalidprodTable);
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 4, new Insets(0, 0, 0, 0), -1, -1));
        AvailableProductPositionsPanel.add(panel5, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel5.setBorder(BorderFactory.createTitledBorder(null, "Доступные позиции товара", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        replenishwarehouseEditorPane = new JEditorPane();
        replenishwarehouseEditorPane.setBackground(new Color(-7035706));
        replenishwarehouseEditorPane.setEditable(false);
        replenishwarehouseEditorPane.setForeground(new Color(-16777216));
        replenishwarehouseEditorPane.setText("Пополнить товары");
        panel5.add(replenishwarehouseEditorPane, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        idEditorPane = new JEditorPane();
        idEditorPane.setEditable(false);
        idEditorPane.setEnabled(true);
        idEditorPane.setText("id");
        panel5.add(idEditorPane, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer7 = new com.intellij.uiDesigner.core.Spacer();
        panel5.add(spacer7, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        textField8 = new JTextField();
        panel5.add(textField8, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        ValueEditorPane1 = new JEditorPane();
        ValueEditorPane1.setEditable(false);
        ValueEditorPane1.setText("Количество");
        panel5.add(ValueEditorPane1, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        textField9 = new JTextField();
        panel5.add(textField9, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        addButton = new JButton();
        addButton.setText("Добавить");
        panel5.add(addButton, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel6 = new JPanel();
        panel6.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 4, new Insets(0, 0, 0, 0), -1, -1));
        AvailableProductPositionsPanel.add(panel6, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        idEditorPane1 = new JEditorPane();
        idEditorPane1.setEditable(false);
        idEditorPane1.setText("id");
        panel6.add(idEditorPane1, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer8 = new com.intellij.uiDesigner.core.Spacer();
        panel6.add(spacer8, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        AvailableEditorPane = new JEditorPane();
        AvailableEditorPane.setEditable(false);
        AvailableEditorPane.setText(" Наличие товара на складе");
        panel6.add(AvailableEditorPane, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer9 = new com.intellij.uiDesigner.core.Spacer();
        panel6.add(spacer9, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        CheckButton = new JButton();
        CheckButton.setText("Проверить");
        panel6.add(CheckButton, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textField10 = new JTextField();
        panel6.add(textField10, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JPanel panel7 = new JPanel();
        panel7.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel6.add(panel7, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        textfield15 = new JTextField();
        panel7.add(textfield15, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        deleteproductbuttom = new JButton();
        deleteproductbuttom.setText("Удалить");
        panel7.add(deleteproductbuttom, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        deleteProductEditorPane = new JEditorPane();
        deleteProductEditorPane.setText("Удалить товар по id");
        panel7.add(deleteProductEditorPane, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer10 = new com.intellij.uiDesigner.core.Spacer();
        panel6.add(spacer10, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        GroupingProduct = new JPanel();
        GroupingProduct.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        MainPanel.add(GroupingProduct, new com.intellij.uiDesigner.core.GridConstraints(1, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        GroupingProduct.setBorder(BorderFactory.createTitledBorder(null, "Группировка товаров по видам", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        final JScrollPane scrollPane3 = new JScrollPane();
        GroupingProduct.add(scrollPane3, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        list3 = new JList();
        final DefaultListModel defaultListModel2 = new DefaultListModel();
        list3.setModel(defaultListModel2);
        scrollPane3.setViewportView(list3);
        final JScrollPane scrollPane4 = new JScrollPane();
        GroupingProduct.add(scrollPane4, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        list4 = new JList();
        scrollPane4.setViewportView(list4);
        final JPanel panel8 = new JPanel();
        panel8.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        GroupingProduct.add(panel8, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        ProductTypeEditorPane = new JEditorPane();
        ProductTypeEditorPane.setEditable(false);
        ProductTypeEditorPane.setText("Тип товара");
        panel8.add(ProductTypeEditorPane, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        final JPanel panel9 = new JPanel();
        panel9.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        GroupingProduct.add(panel9, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        productEditorPane = new JEditorPane();
        productEditorPane.setEditable(false);
        productEditorPane.setText("Товары");
        panel9.add(productEditorPane, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        ShowInfoBuyersPanel = new JPanel();
        ShowInfoBuyersPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 2, new Insets(0, 0, 0, 0), -1, -1));
        MainPanel.add(ShowInfoBuyersPanel, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        ShowInfoBuyersPanel.setBorder(BorderFactory.createTitledBorder(null, "Информация по покупателям", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        final JScrollPane scrollPane5 = new JScrollPane();
        ShowInfoBuyersPanel.add(scrollPane5, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        jlist11 = new JList();
        scrollPane5.setViewportView(jlist11);
        final JScrollPane scrollPane6 = new JScrollPane();
        ShowInfoBuyersPanel.add(scrollPane6, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        jlist12 = new JList();
        scrollPane6.setViewportView(jlist12);
        final JPanel panel10 = new JPanel();
        panel10.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        ShowInfoBuyersPanel.add(panel10, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        buyerjpane = new JEditorPane();
        buyerjpane.setEditable(false);
        buyerjpane.setText("Покупатели");
        panel10.add(buyerjpane, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        final JPanel panel11 = new JPanel();
        panel11.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        ShowInfoBuyersPanel.add(panel11, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        givedproductjapne = new JEditorPane();
        givedproductjapne.setEditable(false);
        givedproductjapne.setText("Выданные товары");
        panel11.add(givedproductjapne, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        final JPanel panel12 = new JPanel();
        panel12.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        ShowInfoBuyersPanel.add(panel12, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        textField5 = new JTextField();
        panel12.add(textField5, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        deletebutton = new JButton();
        deletebutton.setText("Удалить");
        panel12.add(deletebutton, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        deletbuyerEditorPanel = new JEditorPane();
        deletbuyerEditorPanel.setText("Удалить покупателя по id");
        panel12.add(deletbuyerEditorPanel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return MainPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        list1 = new JList<>();
        list2 = new JList<>();
        columnnames = new Vector();
        columnnames.add("id");
        columnnames.add("Название");
        columnnames.add("Цена");
        columnnames.add("Тип");
        columnnames.add("Поставщик");
        columnnames.add("Количество");
        avalidprodTable = new JTable(dbrepository.getTableData(Const.PRODUCT_TABLE), columnnames);
    }
}
