//
//  ViewController.swift
//  WeCare
//
//  Created by paras jagani on 2/25/18.
//  Copyright © 2018 CSULB. All rights reserved.
//

import UIKit
import FBSDKLoginKit

class ViewController: UIViewController{

    override func viewDidLoad() {
        super.viewDidLoad()
        
        let FBloginButton=FBSDKLoginButton()
        view.addSubview(FBloginButton)
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        
    }


}

