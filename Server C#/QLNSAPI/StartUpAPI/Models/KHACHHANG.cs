namespace StartUpAPI.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("KHACHHANG")]
    public partial class KHACHHANG
    {
        [Key]
        [StringLength(8)]
        public string makh { get; set; }

        [Required]
        [StringLength(25)]
        public string tenkh { get; set; }

        [Required]
        [StringLength(100)]
        public string diachi { get; set; }

        [Required]
        [StringLength(12)]
        public string sodienthoai { get; set; }

        [Required]
        [StringLength(50)]
        public string email { get; set; }

        [Required]
        [StringLength(50)]
        public string matkhaukh { get; set; }
<<<<<<< HEAD
=======

>>>>>>> master
    }
}
