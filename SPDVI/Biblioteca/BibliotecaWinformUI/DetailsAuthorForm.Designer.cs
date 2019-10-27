namespace BibliotecaWinformUI
{
    partial class DetailsAuthorForm
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
            this.labelNacionalitat = new System.Windows.Forms.Label();
            this.labelDataNaix = new System.Windows.Forms.Label();
            this.labelID = new System.Windows.Forms.Label();
            this.labelNom = new System.Windows.Forms.Label();
            this.bOk = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // labelNacionalitat
            // 
            this.labelNacionalitat.AutoSize = true;
            this.labelNacionalitat.Location = new System.Drawing.Point(23, 176);
            this.labelNacionalitat.Name = "labelNacionalitat";
            this.labelNacionalitat.Size = new System.Drawing.Size(82, 17);
            this.labelNacionalitat.TabIndex = 15;
            this.labelNacionalitat.Text = "Nacionalitat";
            // 
            // labelDataNaix
            // 
            this.labelDataNaix.AutoSize = true;
            this.labelDataNaix.Location = new System.Drawing.Point(23, 145);
            this.labelDataNaix.Name = "labelDataNaix";
            this.labelDataNaix.Size = new System.Drawing.Size(69, 17);
            this.labelDataNaix.TabIndex = 14;
            this.labelDataNaix.Text = "Data Naix";
            // 
            // labelID
            // 
            this.labelID.AutoSize = true;
            this.labelID.Location = new System.Drawing.Point(23, 116);
            this.labelID.Name = "labelID";
            this.labelID.Size = new System.Drawing.Size(21, 17);
            this.labelID.TabIndex = 13;
            this.labelID.Text = "ID";
            // 
            // labelNom
            // 
            this.labelNom.AutoSize = true;
            this.labelNom.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F);
            this.labelNom.Location = new System.Drawing.Point(18, 87);
            this.labelNom.Name = "labelNom";
            this.labelNom.Size = new System.Drawing.Size(44, 20);
            this.labelNom.TabIndex = 12;
            this.labelNom.Text = "Nom";
            // 
            // bOk
            // 
            this.bOk.Location = new System.Drawing.Point(22, 210);
            this.bOk.Name = "bOk";
            this.bOk.Size = new System.Drawing.Size(75, 23);
            this.bOk.TabIndex = 10;
            this.bOk.Text = "Ok";
            this.bOk.UseVisualStyleBackColor = true;
            this.bOk.Click += new System.EventHandler(this.bOk_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 20F);
            this.label1.Location = new System.Drawing.Point(155, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(363, 39);
            this.label1.TabIndex = 9;
            this.label1.Text = "CIFP Pau Casesnoves";
            // 
            // DetailsAuthorForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 261);
            this.Controls.Add(this.labelNacionalitat);
            this.Controls.Add(this.labelDataNaix);
            this.Controls.Add(this.labelID);
            this.Controls.Add(this.labelNom);
            this.Controls.Add(this.bOk);
            this.Controls.Add(this.label1);
            this.Name = "DetailsAuthorForm";
            this.Text = "DetailsAuthorForm";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label labelNacionalitat;
        private System.Windows.Forms.Label labelDataNaix;
        private System.Windows.Forms.Label labelID;
        private System.Windows.Forms.Label labelNom;
        private System.Windows.Forms.Button bOk;
        private System.Windows.Forms.Label label1;
    }
}