namespace BibliotecaWinformUI
{
    partial class DetailsForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.bOk = new System.Windows.Forms.Button();
            this.labelTitol = new System.Windows.Forms.Label();
            this.labelID = new System.Windows.Forms.Label();
            this.labelDescrip = new System.Windows.Forms.Label();
            this.labelAutor = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 20F);
            this.label1.Location = new System.Drawing.Point(146, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(363, 39);
            this.label1.TabIndex = 0;
            this.label1.Text = "CIFP Pau Casesnoves";
            // 
            // bOk
            // 
            this.bOk.Location = new System.Drawing.Point(13, 210);
            this.bOk.Name = "bOk";
            this.bOk.Size = new System.Drawing.Size(75, 23);
            this.bOk.TabIndex = 3;
            this.bOk.Text = "Ok";
            this.bOk.UseVisualStyleBackColor = true;
            this.bOk.Click += new System.EventHandler(this.bOk_Click);
            // 
            // labelTitol
            // 
            this.labelTitol.AutoSize = true;
            this.labelTitol.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F);
            this.labelTitol.Location = new System.Drawing.Point(9, 87);
            this.labelTitol.Name = "labelTitol";
            this.labelTitol.Size = new System.Drawing.Size(41, 20);
            this.labelTitol.TabIndex = 5;
            this.labelTitol.Text = "Titol";
            // 
            // labelID
            // 
            this.labelID.AutoSize = true;
            this.labelID.Location = new System.Drawing.Point(14, 116);
            this.labelID.Name = "labelID";
            this.labelID.Size = new System.Drawing.Size(21, 17);
            this.labelID.TabIndex = 6;
            this.labelID.Text = "ID";
            // 
            // labelDescrip
            // 
            this.labelDescrip.AutoSize = true;
            this.labelDescrip.Location = new System.Drawing.Point(14, 145);
            this.labelDescrip.Name = "labelDescrip";
            this.labelDescrip.Size = new System.Drawing.Size(74, 17);
            this.labelDescrip.TabIndex = 7;
            this.labelDescrip.Text = "Descripcio";
            // 
            // labelAutor
            // 
            this.labelAutor.AutoSize = true;
            this.labelAutor.Location = new System.Drawing.Point(14, 176);
            this.labelAutor.Name = "labelAutor";
            this.labelAutor.Size = new System.Drawing.Size(42, 17);
            this.labelAutor.TabIndex = 8;
            this.labelAutor.Text = "Autor";
            // 
            // DetailsForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(699, 260);
            this.Controls.Add(this.labelAutor);
            this.Controls.Add(this.labelDescrip);
            this.Controls.Add(this.labelID);
            this.Controls.Add(this.labelTitol);
            this.Controls.Add(this.bOk);
            this.Controls.Add(this.label1);
            this.Name = "DetailsForm";
            this.Text = "DetailsForm";
            this.Load += new System.EventHandler(this.DetailsForm_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button bOk;
        private System.Windows.Forms.Label labelTitol;
        private System.Windows.Forms.Label labelID;
        private System.Windows.Forms.Label labelDescrip;
        private System.Windows.Forms.Label labelAutor;
    }
}