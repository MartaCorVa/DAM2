namespace BibliotecaWinformUI
{
    partial class AuthorForm
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
            this.titleForm = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.infoAuthor = new System.Windows.Forms.TextBox();
            this.bSearch = new System.Windows.Forms.Button();
            this.listBoxAuthor = new System.Windows.Forms.ListBox();
            this.bGoBooks = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // titleForm
            // 
            this.titleForm.AutoSize = true;
            this.titleForm.Font = new System.Drawing.Font("Microsoft Sans Serif", 20F);
            this.titleForm.Location = new System.Drawing.Point(195, 9);
            this.titleForm.Name = "titleForm";
            this.titleForm.Size = new System.Drawing.Size(363, 39);
            this.titleForm.TabIndex = 0;
            this.titleForm.Text = "CIFP Pau Casesnoves";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(46, 99);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(103, 17);
            this.label1.TabIndex = 1;
            this.label1.Text = "Search Author:";
            // 
            // infoAuthor
            // 
            this.infoAuthor.Location = new System.Drawing.Point(49, 119);
            this.infoAuthor.Name = "infoAuthor";
            this.infoAuthor.Size = new System.Drawing.Size(425, 22);
            this.infoAuthor.TabIndex = 6;
            // 
            // bSearch
            // 
            this.bSearch.Location = new System.Drawing.Point(483, 118);
            this.bSearch.Name = "bSearch";
            this.bSearch.Size = new System.Drawing.Size(75, 23);
            this.bSearch.TabIndex = 5;
            this.bSearch.Text = "Find";
            this.bSearch.Click += new System.EventHandler(this.bSearch_Click);
            // 
            // listBoxAuthor
            // 
            this.listBoxAuthor.FormattingEnabled = true;
            this.listBoxAuthor.ItemHeight = 16;
            this.listBoxAuthor.Location = new System.Drawing.Point(49, 170);
            this.listBoxAuthor.Name = "listBoxAuthor";
            this.listBoxAuthor.Size = new System.Drawing.Size(509, 260);
            this.listBoxAuthor.TabIndex = 4;
            this.listBoxAuthor.DoubleClick += new System.EventHandler(this.listBoxAuthor_DoubleClick);
            // 
            // bGoBooks
            // 
            this.bGoBooks.Location = new System.Drawing.Point(614, 407);
            this.bGoBooks.Name = "bGoBooks";
            this.bGoBooks.Size = new System.Drawing.Size(146, 23);
            this.bGoBooks.TabIndex = 7;
            this.bGoBooks.Text = "Search book";
            this.bGoBooks.UseVisualStyleBackColor = true;
            this.bGoBooks.Click += new System.EventHandler(this.bGoBooks_Click);
            // 
            // AuthorForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.bGoBooks);
            this.Controls.Add(this.listBoxAuthor);
            this.Controls.Add(this.bSearch);
            this.Controls.Add(this.infoAuthor);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.titleForm);
            this.Name = "AuthorForm";
            this.Text = "AuthorForm";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label titleForm;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox infoAuthor;
        private System.Windows.Forms.Button bSearch;
        private System.Windows.Forms.ListBox listBoxAuthor;
        private System.Windows.Forms.Button bGoBooks;
    }
}