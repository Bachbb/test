package CoffeeShop.GUI.bill;

import CoffeeShop.DAO.impl.BillDao;
import CoffeeShop.DAO.impl.BillDetailDao;
import CoffeeShop.Obj.Bill;
import CoffeeShop.Obj.BillDetail;
import CoffeeShop.Util.Common;
import CoffeeShop.Util.DbUtil;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.NumberFormat;
import java.util.List;
import javax.swing.BorderFactory;

public final class JDBill extends javax.swing.JDialog {
    private DbUtil dbUtil;

    private Bill bill = null;

    private List<BillDetail> billDetails = null;

    private BillDao billDao = null;
    private BillDetailDao billDetailDao = null;


    public JDBill(Frame parent, boolean modal, DbUtil dbUtil, Bill bill) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.dbUtil = dbUtil;
        this.bill = bill;
        this.billDao = new BillDao(dbUtil);
        this.billDetailDao = new BillDetailDao(dbUtil);

        txtBillId.setText(String.valueOf(bill.getId()));
        txtBillTime.setText(String.valueOf(bill.getCreated_at()));
        txtNameTable.setText(String.valueOf(bill.getTable_name()));
        txtBillTotalPrice.setText(NumberFormat.getInstance().format(bill.getTotal_price()));
        loading();

        // Custom Style
        txtBillId.setBorder(BorderFactory.createCompoundBorder(
                txtBillId.getBorder(),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)));
        txtBillTime.setBorder(BorderFactory.createCompoundBorder(
                txtBillTime.getBorder(),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)));
        txtBillTotalPrice.setBorder(BorderFactory.createCompoundBorder(
                txtBillTotalPrice.getBorder(),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)));
        txtNameTable.setBorder(BorderFactory.createCompoundBorder(
                txtNameTable.getBorder(),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)));
    }

    private void loading() {
        tblBillDetail.removeAll();
        billDetails = billDetailDao.getAll(bill.getId());

        String columns[] = {"ID", "Tên sản phẩm", "Đơn giá", "Số lượng", "Thành tiền"};
        DefaultTableModel dtm = new DefaultTableModel(columns, 0);

        if (!Common.isNullOrEmpty(billDetails)) {
            billDetails.forEach(obj -> {
                int total = (int) (obj.getProduct_price() * obj.getAmount());
                dtm.addRow(new Object[]{obj.getProduct_id(), obj.getProduct_name(), NumberFormat.getInstance().format(obj.getProduct_price()), obj.getAmount(), NumberFormat.getInstance().format(total)});
            });

            tblBillDetail.changeSelection(0, 0, false, false);
        }

        tblBillDetail.setModel(dtm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblBillId = new javax.swing.JLabel();
        txtBillId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBillDetail = new javax.swing.JTable();
        lblBillTime = new javax.swing.JLabel();
        txtBillTime = new javax.swing.JTextField();
        lblNameTable = new javax.swing.JLabel();
        txtNameTable = new javax.swing.JTextField();
        lblBillTotalPrice = new javax.swing.JLabel();
        txtBillTotalPrice = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("THÔNG TIN CHI TIẾT HOÁ ĐƠN");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_product_50px_2.png"))); // NOI18N
        lblTitle.setText("THÔNG TIN CHI TIẾT HOÁ ĐƠN");

        lblBillId.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        lblBillId.setText("Mã hoá đơn");

        txtBillId.setEditable(false);

        tblBillDetail.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        tblBillDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        )
    );
    jScrollPane1.setViewportView(tblBillDetail);

    lblBillTime.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
    lblBillTime.setText("Thời gian");

    txtBillTime.setEditable(false);

    lblNameTable.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
    lblNameTable.setText("Tên bàn");

    txtNameTable.setEditable(false);

    lblBillTotalPrice.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
    lblBillTotalPrice.setText("Tổng tiền");

    txtBillTotalPrice.setEditable(false);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
                .addComponent(jScrollPane1)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtBillId)
                        .addComponent(lblBillId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNameTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNameTable))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblBillTime, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblBillTotalPrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                        .addComponent(txtBillTotalPrice, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtBillTime, javax.swing.GroupLayout.Alignment.LEADING))))
            .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(lblTitle)
            .addGap(14, 14, 14)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addComponent(lblBillId, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBillId, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBillTime, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addComponent(lblBillTime, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(52, 52, 52)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(lblNameTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblBillTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtBillTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtNameTable, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBillId;
    private javax.swing.JLabel lblBillTime;
    private javax.swing.JLabel lblBillTotalPrice;
    private javax.swing.JLabel lblNameTable;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblBillDetail;
    private javax.swing.JTextField txtBillId;
    private javax.swing.JTextField txtBillTime;
    private javax.swing.JTextField txtBillTotalPrice;
    private javax.swing.JTextField txtNameTable;
    // End of variables declaration//GEN-END:variables
}
