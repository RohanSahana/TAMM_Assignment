//
//  TableViewCell.swift
//  ViperDemo
//
//  Created by Devesh Agarwal on 05/05/24.
//  Copyright © 2024 Abhisek. All rights reserved.
//

import UIKit

class TableViewCell: UITableViewCell {

    @IBOutlet weak var NameLbl: UILabel!
    
    @IBOutlet weak var UnvLbl: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}
