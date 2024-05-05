

import UIKit

class FruitDetailView: UIViewController,FruitDetailViewProtocol {


    @IBOutlet weak var stateLbl: UILabel!
    @IBOutlet var NameLbl: UILabel!
    @IBOutlet var UnvLbl: UILabel!
    
    var presenter: FruitDetailPresenterProtocol?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        presenter?.viewDidLoad()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    func showFruitDetail(with fruit: Fruit) {
       // print("Fruit ---> " , fruit)
        title = fruit.name
        // fruitImage.image = UIImage(named: fruit.name)
        stateLbl.text = "University Name  " + fruit.name
        NameLbl.text = "Country Name  " + fruit.country
        UnvLbl.text = "State Name  " + fruit.alphatwocode
    }
    
    deinit {
        print("FruitDetailView removed")
    }

}
