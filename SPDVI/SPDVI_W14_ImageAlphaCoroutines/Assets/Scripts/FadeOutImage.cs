using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class FadeOutImage : MonoBehaviour
{

    Image imageComponentRef;

    // Start is called before the first frame update
    void Start()
    {
        imageComponentRef = gameObject.GetComponent<Image>();
    }

    // Update is called once per frame
    void Update()
    {
        if (Input.GetKeyDown(KeyCode.F))
        {
            StartCoroutine(Fade());

        }
    }

    public void OnClickImage()
    {
        StartCoroutine(Delay2s());
        Debug.Log("We are in OnClickImage");
    }

    IEnumerator Delay2s()
    {
        Debug.Log("Entered coroutine...");
        yield return new WaitForSeconds(2);
        Debug.Log("It is now 2 seconds later!");
    }

    IEnumerator Fade()
    {
        for (float ft = 1f; ft >= 0f; ft -= 0.1f)
        {
            Color c = imageComponentRef.color;
            c.a = ft;
            imageComponentRef.color = c;
            // yield return null;
            yield return new WaitForSeconds(0.1f);
        }
    }

}